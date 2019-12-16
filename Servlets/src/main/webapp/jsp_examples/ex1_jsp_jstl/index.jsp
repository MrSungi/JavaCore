<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL Examples</title>
</head>
<body>

<!-- 0. Core tags -->
<!-- set and if -->
<h3>Core tags</h3>
<c:set var = "salary" scope = "session" value = "${2000*2}"/>
<c:if test = "${salary > 2000}">
<p>My salary is:  <c:out value = "${salary}"/><p>
    </c:if>

    <!-- forEach -->
<h3>ForEach</h3>
<c:forEach var = "i" begin = "1" end = "5">
<p>Item <span style="color: lightseagreen"><c:out value = "${i}"/></span><p>
    </c:forEach>

    <!-- forTokens -->
<h3>ForTokens</h3>
<c:forTokens items = "Zara,nuha,roshy" delims = "," var = "name">
    <p><c:out value = "${name}"/></p>
</c:forTokens>

<!-- manipulating beans -->
<h3>Accessing Bean properties</h3>
<jsp:useBean id="tb" class="com.ignas.model.TestBean" />
<c:forTokens items = "${tb.message}" delims = " " var = "substr">
    <p><c:out value = "${substr}"/></p>
</c:forTokens>

<!-- looping with a counter variable on bean property (collection) -->
<h3>Looping over Bean property (which is an array List)</h3>
<c:forEach begin="0" items="${tb.someCollection}" var="item" varStatus="counter">
Item ${counter.index} ${item}<p>
    </c:forEach>

    <!-- 1. Formatting tags -->
    <%-- Left as an excercise: display current date in various formats --%>
    <%-- Left as an excercise: extend the collection in our bean - apply formating to data inside the collection --%>

</body>
</html>
