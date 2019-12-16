<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Blog posts</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
<body>

<!-- looping with a counter variable on bean property (collection) -->
<h1>Blog posts</h1>
<jsp:useBean id="blogPostService" class="com.ignas.ex7_mvc.service.BlogPostService" />

<%--  One way to display blog posts - table --%>
<table>
    <c:forEach begin="0" items="${blogPostService.all}" var="blogPost" varStatus="counter">
        <tr>
            <td>${counter.index}</td>
            <td>${blogPost.title}</td>
            <td>${blogPost.postBody}</td>
            <td><a href="/blogpost/delete/${blogPost.id}">DELETE THE BASTARD</a></td>
        </tr>
    </c:forEach>
</table>

<%--  ... another way, bunch for paragraphs with h1 tags --%>
<c:forEach begin="0" items="${blogPostService.all}" var="blogPost" varStatus="counter">
    <h3>${blogPost.title}</h3><hr>
    <article>${blogPost.postBody}</article>
</c:forEach>
</body>
</html>