package com.example.servletcrud;

import jakarta.servlet.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Home", urlPatterns = {"/", "/home"})
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/pages/index.jsp");
        requestDispatcher.forward(request, response);

    }

}
