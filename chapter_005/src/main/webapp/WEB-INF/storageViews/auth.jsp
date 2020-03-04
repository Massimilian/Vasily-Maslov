<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.02.2020
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/auth" method="post">
    Change your role:
    <select name="role">
        <option>Admin</option>
        <option>User</option>
    </select>
    <input type="submit" value="OK">
</form>
</body>
</html>
