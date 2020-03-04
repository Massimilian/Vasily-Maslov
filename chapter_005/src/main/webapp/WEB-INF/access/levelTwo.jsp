<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.02.2020
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Level Two autorization</title>
</head>
<body>
<p style="background-color: yellow">${error}</p>
<form action="${pageContext.servletContext.contextPath}/accesspagetwo" method="post">
    <p>Enter text "TWO" twice:</p>
    <input type="text" name="one">
    <input type="text" name="two">
    <input type="submit" name="OK">
</form>
</body>
</html>
