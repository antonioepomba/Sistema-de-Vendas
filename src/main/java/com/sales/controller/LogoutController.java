package com.sales.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class LogoutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        session.setAttribute("LoginController",Boolean.TRUE);
        if (session.getAttribute("username") != null) {
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request, response);
            return; // <--- Here.
        }
    }
}
