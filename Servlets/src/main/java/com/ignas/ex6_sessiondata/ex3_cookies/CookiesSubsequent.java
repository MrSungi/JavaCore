package com.ignas.ex6_sessiondata.ex3_cookies;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CookiesSubsequent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Cookie userData[] = request.getCookies();
        // String guestName = userData[0].getValue();
        // Students should be able to implement findCookieByName() method
        String guestName = null;
        for (Cookie cookie : userData){
            if(cookie.getName().equals("guestName")){
                guestName = cookie.getValue();
                break;
            }
        }
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CookiesSubsequent </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Please confirm your information </p>");
        out.println("<p>Guest Name : " + guestName + "</p>");
        out.println("<p>Email Id : " + email + "</p>");
        Cookie emailData = new Cookie("email", email);
        response.addCookie(emailData);
        out.println("<form name='frm' action='CookiesFinal' method='post'>");
        out.println("<p><input type='submit' value='Save Data' name='btnSave' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}