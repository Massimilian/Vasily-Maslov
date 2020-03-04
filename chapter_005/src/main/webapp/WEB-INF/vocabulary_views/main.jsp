<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11.02.2020
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Main page</title>
</head>
<body>
<h1>Welcome, my friend!</h1>
<h2>Look at these words...</h2>
<table style="border: 1px solid black" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th style="background-color: gold">English words</th>
        <th style="background-color: palegreen">Russian words</th>
    </tr>
    <c:forEach items="${words}" var="word">
        <tr>
            <td style="background-color: yellow"><c:out value="${word.word}"></c:out></td>
            <td style="background-color: lime"><c:out value="${word.value}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.servletContext.contextPath}/vocabularyadd" method="post">
    <input type="submit" value="Add new.">
</form>
<form action="${pageContext.servletContext.contextPath}/vocabularydelete" method="post">
    <input type="submit" value="Delete...">
</form>
<form action="${pageContext.servletContext.contextPath}/vocabularychecking">
    <input type="submit" value="Check your knowledge!">
</form>
<form action="${pageContext.servletContext.contextPath}/vocabularyexit">
    <input type="submit" value="Exit?">
</form>
</body>
</html>
