package com.ignas.ex6_sessiondata.ex4_session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionSubsequent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        String guestName = (String)session.getAttribute("guestName");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SessionSubsequent </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Please confirm your information </p>");
        out.println("<p>Guest Name : " + guestName + "</p>");
        out.println("<p>Email Id : " + email + "</p>");
        session.setAttribute("email", email);
        out.println("<form name='frm' action='SessionFinal' method='post'>");
        out.println("<p><input type='submit' value='Save Data' name='btnSave' />");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}