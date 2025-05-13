package org.lab.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lab.dao.BookingDAO;
import org.lab.dao.impl.BookingDAOImpl;
import org.lab.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class RoomsServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(RoomsServlet.class);
    private final BookingDAO bookingDAO = new BookingDAOImpl();

    public RoomsServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!AuthenticationUtils.isAuthenticated(req, resp)) {
            return;
        }
        logger.info("Rendering rooms page for authenticated user");
        req.getRequestDispatcher("/WEB-INF/views/rooms.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!AuthenticationUtils.isAuthenticated(req, resp)) {
            return;
        }

        int userId = (int) req.getSession().getAttribute("userId");
        String action = req.getParameter("action");
        if ("createRequest".equals(action)) {
            try {
                Booking booking = new Booking(
                        userId,
                        req.getParameter("firstName"),
                        req.getParameter("middleName"),
                        req.getParameter("phone"),
                        Integer.parseInt(req.getParameter("capacity")),
                        req.getParameter("roomClass"),
                        Date.valueOf(req.getParameter("startDate")),
                        Date.valueOf(req.getParameter("endDate"))
                );
                logger.info("Creating booking request for userId: {}", userId);
                bookingDAO.create(booking); // Статус "pending" встановлюється в конструкторі Booking
                resp.sendRedirect(req.getContextPath() + "/rooms");
            } catch (Exception e) {
                logger.error("Error creating booking request", e);
                req.setAttribute("error", "Failed to create request: " + e.getMessage());
                req.getRequestDispatcher("/WEB-INF/views/rooms.jsp").forward(req, resp);
            }
        }
    }
}