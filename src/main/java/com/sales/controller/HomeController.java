package com.sales.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class HomeController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

                HttpSession session = request.getSession(false);
                session.setAttribute("LoginController",Boolean.TRUE);
                if (session.getAttribute("username") != null) {
                    request.getRequestDispatcher("dashboard.jsp").include(request, response);
            } else {

                    request.getRequestDispatcher("index.jsp").include(request, response);
        }


    }
}