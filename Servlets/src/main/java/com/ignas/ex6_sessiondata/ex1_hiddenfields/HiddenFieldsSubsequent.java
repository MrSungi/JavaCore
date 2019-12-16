package com.ignas.ex6_sessiondata.ex1_hiddenfields;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HiddenFieldsSubsequent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + this.getClass().getName() + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Please confirm your information </p>");
        out.println("<p>Guest Name : " + guestName + "</p>");
        out.println("<p>Email Id : " + email + "</p>");
        out.println("<form name='frm' action='SaveData' method='post'>");
        out.println("<input type='hidden' name='guestName' value='" + guestName + "'/>");
        out.println("<input type='hidden' name='email' value='" + email + "'/>");
        out.println("<p><input type='submit' value='Save guest data' name='btnSave' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
