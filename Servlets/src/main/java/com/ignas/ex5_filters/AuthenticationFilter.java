package com.ignas.ex5_filters;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class AuthenticationFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter method is called in " + this.getClass().getName());

        String userName = request.getParameter("username");
        String passwd  = request.getParameter("passwd");

        String ipAddress = request.getRemoteAddr();

        if(userName != null || passwd != null){
            if((userName.equals("ignas") && passwd.equals("qwerty")) || ((userName.equals("m") && passwd.equals("b")))){
                System.out.println("User logged in " + ipAddress + " at " + new Date().toString());
                chain.doFilter(request, response);
            } else{
                PrintWriter out = response.getWriter();
                out.println("<body><h3>Sorry, You are not authorized to access this resource. </h3></body>");
            }
        } else {
            response.getWriter().println("<body><h3>Sorry, You are not authorized to access this resource. </h3></body>");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("init method is called in " + this.getClass().getName());
    }
}