package com.ignas.ex0_helloservlet;

import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().print("Hello from our first HttpServlet!");
        //resp.sendError(666, "WELCOME TO HELL!!!!");

    }

}