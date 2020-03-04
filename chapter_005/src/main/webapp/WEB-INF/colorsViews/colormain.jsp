<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.11.2019
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Colors</title>
</head>
<body style="background-color: aliceblue">
<h1 style="color: chartreuse">Choose your color</h1>
<form action="${pageContext.servletContext.contextPath}/getcolor" method="post">
    <h2 style="color: red">Red part (0-99):</h2>
    <input type="text" name="red">
    <h2 style="color: green">Green part (0-99):</h2>
    <input type="text" name="green">
    <h2 style="color: darkblue"> Blue part (0-99)</h2>
    <input type="text" name="blue">
    <input type="submit">
</form>
</body>
</html>
