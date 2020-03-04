<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21.02.2020
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin sign in</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/admincrudsignin" method="post">
    <p style="background-color: red"> ${error} </p>
    <p>Login:</p>
    <input type="text" name="login">
    <p>Password:</p>
    <input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
