package org.lab.route;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class Router {
    private final Map<String, Map<String, RouteHandler>> routes = new HashMap<>();

    public void register(String method, String path, RouteHandler handler) {
        routes.computeIfAbsent(method, k -> new HashMap<>()).put(path, handler);
    }

    public void route(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String path = req.getServletPath();
        String method = req.getMethod();
        RouteHandler handler = routes.getOrDefault(method, Collections.emptyMap()).get(path);
        if (handler != null) {
            handler.handle(req, res);
        } else {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public interface RouteHandler {
        void handle(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
    }
}