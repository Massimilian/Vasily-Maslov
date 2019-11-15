<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.planner.TaskStorage" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14.10.2019
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planner-delete</title>
    <style>
        p {
            font-size: 40px;
        }
    </style>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/start" method="post">

    <c:choose>
        <c:when test="${result == true}">
            <p style="color: green">Delete complite! </p>
        </c:when>
        <c:otherwise>
            <p style="color: red">Delete impossible!</p>
        </c:otherwise>
    </c:choose>
    <input type="submit">
</form>
</body>
</html>
