package com.ignas.ex6_sessiondata.ex4_session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class SessionFinal extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String guestName = (String) session.getAttribute("guestName");
        String email = (String) session.getAttribute("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>SessionSubsequent </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Guest Details </h3>");
        out.println("<p>Guest Name : " + guestName);
        out.println("<p>Email Id : " + email);
        out.println("</body>");
        out.println("</html>");
    }
}