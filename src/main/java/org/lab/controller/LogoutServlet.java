package org.lab.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!AuthenticationUtils.isAuthenticated(req, resp)) {
            return;
        }
        HttpSession session = req.getSession(false);
        if (session != null) {
            logger.info("Logging out user with ID: {}", session.getAttribute("userId"));
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}