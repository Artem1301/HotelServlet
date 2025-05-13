package org.lab.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lab.dao.UserDAO;
import org.lab.dao.impl.UserDAOImpl;
import org.lab.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LoginServlet.class);
    private final UserDAO userDAO = new UserDAOImpl();

    public LoginServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("GET request received for login page");
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        logger.info("Login attempt with login: {}", login);

        User user = userDAO.findByLoginAndPassword(login, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("userId", user.getId());
            session.setAttribute("isAdmin", user.isAdmin());
            logger.info("User authenticated with ID: {}, redirecting to {}", user.getId(), user.isAdmin() ? "/admin" : "/rooms");
            resp.sendRedirect(req.getContextPath() + (user.isAdmin() ? "/admin" : "/rooms"));
        } else {
            logger.warn("Invalid login or password");
            req.setAttribute("error", "Invalid login or password");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}