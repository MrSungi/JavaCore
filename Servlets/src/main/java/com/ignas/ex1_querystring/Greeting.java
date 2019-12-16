package com.ignas.ex1_querystring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Greeting extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        out.println("<p>First Name : " + firstName + "</p>");
        String lastName = request.getParameter("lastName");
        out.println("<p>Last Name : " + lastName + "</p>");
    }
}