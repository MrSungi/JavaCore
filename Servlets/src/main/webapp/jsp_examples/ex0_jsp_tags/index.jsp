<%@page language="java" import="java.util.*" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>First JSP</title>
</head>
<body>
<center>

    <header>
        <%@ include file="../headerandfooter/header.jsp" %>
    </header>

    <!-- 0. Expression Tag -->
    <p>Converting a string to upper case: <%= new String("hello world!").toUpperCase() %>

            <% double num = Math.random();
            if (num > 0.95) { %>
    <h2>You'll have a lucky day!</h2><p>(<%= num %>)</p>
    <% } else { %>
    <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
    <% } %>
    <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>

    <!-- Excercise -->


    <!-- 1. Declaration Tag -->
    <%! double getBonus(double salary){
        return salary * 0.01;
    } %>
    <p>Bonus for employee with salary of 1000 will be: <%= getBonus(1000) %></p>
    <!-- Excercise -->


    <!-- 2. Scriptlet Tag -->
    <% for(int i = 1; i <= 10; i++){
        out.println(i + "<br/>");
    } %>
    <!-- Excercise -->

    <!-- 3. Calendar comes from @Page directive above -->
    <p>Copyright &copy; Mindaugas Corp. <%= Calendar.getInstance().get(Calendar.YEAR) %></p>

    <!-- 4. @Include directive -->
    <footer>
        <%@ include file="../headerandfooter/footer.jsp" %>
    </footer>
</center>
</body>
</html>