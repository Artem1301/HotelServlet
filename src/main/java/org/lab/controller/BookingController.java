package org.lab.controller;

import org.lab.model.Booking;
import org.lab.service.BookingService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookingController {
    private final BookingService service = new BookingService();

    public void createBooking(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Booking booking = new Booking(
                Integer.parseInt(req.getParameter("guests")),
                req.getParameter("room-class"),
                req.getParameter("check-in"),
                req.getParameter("check-out")
        );
        service.save(booking);
        res.sendRedirect("/");
    }

    public void showBookings(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Booking> bookings = service.findAll();
        req.setAttribute("bookings", bookings);
        req.getRequestDispatcher("/views/admin.jsp").forward(req, res);
    }
}