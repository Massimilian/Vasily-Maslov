<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.02.2020
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Level One autorization</title>
</head>
<body>
<p style="background-color: lime">${error}</p>
<form action="${pageContext.servletContext.contextPath}/accesspageone" method="post">
    <p>Enter text "ONE":</p>
    <input type="text" name="one">
    <input type="submit" name="OK">
</form>
</body>
</html>
