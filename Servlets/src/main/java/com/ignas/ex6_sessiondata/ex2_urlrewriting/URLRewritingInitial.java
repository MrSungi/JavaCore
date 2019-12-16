package com.ignas.ex6_sessiondata.ex2_urlrewriting;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class URLRewritingInitial extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Greetings </title>");
        out.println("</head>");
        out.println("<body>");
        String queryString = "guestName=" + guestName + "&email=" + email;
        out.println("<a href='URLRewritingSubsequent?" + queryString + "'>Display Data </a> &nbsp;"
                + "<a href='SaveData?" + queryString + "'>Save Data </a>");
        out.println("</body>");
        out.println("</html>");
    }
}