package com.ignas.ex6_sessiondata.ex3_cookies;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CookiesFinal extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie userData[] = request.getCookies();
        String guestName = null;
        String email = null;

        boolean guestNameCookieFound = false;
        boolean emailCookieFound = false;
        for (Cookie cookie : userData){
            if(cookie.getName().equals("guestName")){
                guestName = cookie.getValue();
                guestNameCookieFound = true;
                if(emailCookieFound) break;
            }
            if(cookie.getName().equals("email")){
                email = cookie.getValue();
                emailCookieFound = true;
                if(guestNameCookieFound) break;
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>CookiesSubsequent </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Guest Details </h3>");
        out.println("<p>Guest Name : " + guestName);
        out.println("<p>Email Id : " + email);
        out.println("</body>");
        out.println("</html>");
    }
}