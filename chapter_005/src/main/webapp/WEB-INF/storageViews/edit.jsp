<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.09.2019
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/work" method="post">
    Enter ID number :
    <input type="text" name="id">
    New name :
    <input type="text" name="name">
    New login :
    <input type="text" name="login">
    New e-mail :
    <input type="text" name="mail">
    <input type="submit">
</form>
</body>
</html>