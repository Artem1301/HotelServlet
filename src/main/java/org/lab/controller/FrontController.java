package org.lab.controller;

import org.lab.route.Router;
import org.lab.route.Router.RouteHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/")
public class FrontController extends HttpServlet {
    private Router router;

    @Override
    public void init() throws ServletException {
        router = new Router();
        router.register("GET", "/", (req, res) -> req.getRequestDispatcher("/views/booking.jsp").forward(req, res));
        router.register("POST", "/book", new BookingController()::createBooking);
        router.register("GET", "/admin", new BookingController()::showBookings);
        router.register("GET", "/login", (req, res) -> req.getRequestDispatcher("/views/login.jsp").forward(req, res));
        router.register("POST", "/login", new AuthController()::login);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        router.route(req, res);
    }
}