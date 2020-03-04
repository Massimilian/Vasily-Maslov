<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17.02.2020
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crud sign in</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/crudsignin" method="post">
    <p style="background-color: red"> ${error} </p>
    <p>Login:</p>
    <input type="text" name="login">
    <input type="submit">
</form>
</body>
</html>
