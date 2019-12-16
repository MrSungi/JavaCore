package com.ignas.ex6_sessiondata.ex1_hiddenfields;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/SaveData")
public class SaveData extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename=\"addressbook.txt\"");



        try {
            OutputStream outputStream = response.getOutputStream();
            String outputResult = ("Guest Name : " + guestName + ", Email Id : " + email + "\n");
            outputStream.write(outputResult.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}