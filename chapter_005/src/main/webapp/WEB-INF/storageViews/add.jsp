<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.09.2019
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new User</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/work.adm" method="post">
    Name :
    <input type="text" name="name">
    Login :
    <input type="text" name="login">
    E-mail :
    <input type="text" name="mail">
    <input type="submit">
</form>
</body>
</html>
