<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 13.02.2020
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete value</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/vocabularyok" method="post">
    <p>Enter the word for delete:</p> <input type="text" name="word">
    <input type="submit" value="delete">
</form>
</body>
</html>
