package org.lab.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthController {
    public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if ("admin".equals(login) && "admin".equals(password)) {
            req.getSession().setAttribute("user", login);
            res.sendRedirect("/admin");
        } else {
            req.setAttribute("error", "Невірний логін або пароль");
            req.getRequestDispatcher("/views/login.jsp").forward(req, res);
        }
    }
}