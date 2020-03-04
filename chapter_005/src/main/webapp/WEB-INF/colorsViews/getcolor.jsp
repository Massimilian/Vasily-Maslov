<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.11.2019
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color</title>
</head>
<body style="background-color: ${color}; color: ${textColor}">
<h1> WORKS! Yout color is ${color}. </h1>
<form action="${pageContext.servletContext.contextPath}/color" method="get">
    <h1>Get back :</h1><br>
    <input type="submit">
</form>
</body>
</html>
