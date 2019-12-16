package com.ignas.ex6_sessiondata.ex1_hiddenfields;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HiddenFieldsInitial extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Greetings </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Welcome " + guestName + "</h3>");
        out.println("<form name='frm' action='HiddenFieldsSubsequent' method='post'>");

        // the important line is here !
        out.println("<input type='hidden' name='guestName' value='" + guestName +"'/>");

        out.println("<p>Enter Email Id : </p>");
        out.println("<p><input type='email' name='email' /> </p>");
        out.println("<p><input type='submit' value='Submit guest' name='btnPreview' /> </p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}