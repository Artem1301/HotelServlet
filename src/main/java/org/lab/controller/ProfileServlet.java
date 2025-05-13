package org.lab.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lab.dao.UserDAO;
import org.lab.dao.impl.UserDAOImpl;
import org.lab.dao.BookingDAO;
import org.lab.dao.impl.BookingDAOImpl;
import org.lab.model.User;
import org.lab.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProfileServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ProfileServlet.class);
    private final UserDAO userDAO = new UserDAOImpl();
    private final BookingDAO bookingDAO = new BookingDAOImpl();

    public ProfileServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!AuthenticationUtils.isAuthenticated(req, resp)) {
            return;
        }
        int userId = (int) req.getSession().getAttribute("userId");
        try {
            User user = userDAO.findById(userId);
            List<Booking> bookings = bookingDAO.findByUserId(userId);
            req.setAttribute("user", user);
            req.setAttribute("bookings", bookings);
            logger.info("Rendering profile page for userId: {}", userId);
            req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            logger.error("RuntimeException in ProfileServlet: {}", e.getMessage());
            req.setAttribute("error", "An unexpected error occurred: " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);
        }
    }
}