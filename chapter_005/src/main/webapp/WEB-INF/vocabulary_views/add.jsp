<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.02.2020
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new value</title>
</head>
<body>
<h1> Adding new word...</h1>
<form action="${pageContext.servletContext.contextPath}/vocabularyok" method="post">
    <p>English word:</p> <input type="text" name="english">
    <p>Russian word:</p> <input type="text" name="russian">
    <input type="submit" value="OK">
</form>
</body>
</html>
