<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.planner.TaskStorage" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 13.10.2019
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planner-edit</title>
    <style>
        p {
            font-size: 40px;
        }
    </style>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/start" method="post">
    <c:choose>
        <c:when test="${TaskStorage.getInstance().isResult()}">
            <p style="color: green">Edition complite! </p>
        </c:when>
        <c:when test="${!TaskStorage.getInstance().isResult()}">
            <p style="color: red">Edition false! </p>
        </c:when>
    </c:choose>
    <input type="submit">
</form>
</body>
</html>
