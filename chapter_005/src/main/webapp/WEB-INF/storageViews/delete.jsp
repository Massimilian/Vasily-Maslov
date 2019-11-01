<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.09.2019
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/work" method="post">
    Enter ID number :
    <input type="text" name="id">
    <input type="submit">
</form>
</body>
</html>
