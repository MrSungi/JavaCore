package com.ignas.ex1_querystring;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;


public class UserInfo extends HttpServlet {

    public static String escapeHTML(String s) {
        StringBuilder out = new StringBuilder(Math.max(16, s.length()));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
                out.append("&#");
                out.append((int) c);
                out.append(';');
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        out.println("<h3>Reading QueryString data using 'String getParameter(String firstName)' and getParameter(String lastName) methods: </h3>" );
        out.println("<div>");
        // GETTING UNICODE CHARACTERS FROM THE QUERY: URL unescaping for the parameters
        // Solution 1: https://stackoverflow.com/questions/34619248/apache-tomcat-maven-plugin-uriencoding-not-working-with-https
        // Solution 2: https://stackoverflow.com/questions/17212353/how-to-process-encoded-unicode-text-in-servlet
        // General actions to perform: https://www.baeldung.com/tomcat-utf-8

        System.out.println("Query string:" + request.getQueryString());

        if(lastName != null){
        System.out.println("Original: " + lastName);
        }
        if(lastName != null){
        System.out.println("Decoded: " + URLDecoder.decode(lastName, "utf-8"));
        }
        out.println("<p>First Name : " + firstName + "</p>");

        // RETURNING UNICODE CHARACTERS TO THE HTML:
        // Solutions:  https://stackoverflow.com/questions/1265282/recommended-method-for-escaping-html-in-java
        if(lastName != null) {
            out.println("<p>Last Name : " + escapeHTML(lastName) + "</p>");
        }
        out.println("</div>");


        out.println("<h3>Reading QueryString data using 'Enumeration getParameterNames()' method : </h3>");
        Enumeration<String> paramNames = request.getParameterNames();
        out.println( "<div>");
        while( paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            out.println( "<p>" + paramName + " : " +  paramValue + "</p>");
        }
        out.println( "</div>");


        out.println("<h3>Read QueryString data using 'Map getParameterMap()' method </h3>");
        // Why string[] ??? because we can handle multiples of the same parameter name=aaaa&name=bbbb
        Map<String, String[]> paramMap = request.getParameterMap();
        Set<String> paramNamesSet = paramMap.keySet();
        out.println( "<div>");
        for(String paramName : paramNamesSet) {
            String[] paramValues = paramMap.get(paramName);
            out.println( "<p>" + paramName + " : " );
            for( int i=0; i< paramValues.length; i++ ) {
                out.println( paramValues[i]  + "</p>");
            }
        }
        out.println( "</div>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}