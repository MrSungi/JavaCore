package com.ignas.ex3_headersandstatuscodes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContentTypeDemo")
public class ContentTypeDemo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO :: we can use this library to generate excel documents easily: http://poi.apache.org/

        response.setContentType("application/vnd.ms-excel");
        response.setHeader( "Content-Disposition",
                String.format("attachment; filename=\"%s\"", "ExcelFile.xls"));
        PrintWriter out = response.getWriter();
        out.println("Rno\tName\tMaths\tPhys\tComputer Sc\tTotal");
        out.println("101\tMidnaugas\t90\t90\t90\t=SUM(B2:D2)");
        out.println("102\tJonas\t95\t95\t95\t=SUM(B2:D2)");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}