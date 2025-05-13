package org.lab.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lab.dao.BookingDAO;
import org.lab.dao.impl.BookingDAOImpl;
import org.lab.dao.RoomDAO;
import org.lab.dao.impl.RoomDAOImpl;
import org.lab.model.Booking;
import org.lab.model.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(AdminServlet.class);
    private final BookingDAO bookingDAO = new BookingDAOImpl();
    private final RoomDAO roomDAO = new RoomDAOImpl();

    public AdminServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!AuthenticationUtils.isAuthenticated(req, resp)) {
            return;
        }
        if (!Boolean.TRUE.equals(req.getSession().getAttribute("isAdmin"))) {
            logger.warn("Non-admin user attempted to access /admin, redirecting to /rooms");
            resp.sendRedirect(req.getContextPath() + "/rooms");
            return;
        }
        try {
            List<Booking> pendingRequests = bookingDAO.findAllPending();
            List<Room> availableRooms = roomDAO.findAll();
            req.setAttribute("pendingRequests", pendingRequests);
            req.setAttribute("availableRooms", availableRooms);
            logger.info("Rendering admin page with {} pending requests", pendingRequests.size());
            req.getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            logger.error("RuntimeException in AdminServlet: {}", e.getMessage());
            req.setAttribute("error", "An unexpected error occurred: " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!AuthenticationUtils.isAuthenticated(req, resp)) {
            return;
        }
        if (!Boolean.TRUE.equals(req.getSession().getAttribute("isAdmin"))) {
            resp.sendRedirect(req.getContextPath() + "/rooms");
            return;
        }
        try {
            String action = req.getParameter("action");
            if ("assign".equals(action)) {
                int bookingId = Integer.parseInt(req.getParameter("bookingId"));
                int roomId = Integer.parseInt(req.getParameter("roomId"));
                Booking booking = bookingDAO.findById(bookingId);
                if (booking != null) {
                    booking.setRoomId(roomId);
                    booking.setStatus("assigned");
                    bookingDAO.update(booking);
                }
            }
            resp.sendRedirect(req.getContextPath() + "/admin");
        } catch (RuntimeException e) {
            logger.error("RuntimeException in AdminServlet POST: {}", e.getMessage());
            req.setAttribute("error", "An unexpected error occurred: " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(req, resp);
        }
    }
}