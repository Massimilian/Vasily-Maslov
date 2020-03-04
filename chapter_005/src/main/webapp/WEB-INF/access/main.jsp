<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.02.2020
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access</title>
</head>
<body>
<p>Change your access:</p>
<form action="${pageContext.servletContext.contextPath}/accessmain" method="post">
    <select name="level">
        <option>Level #1</option>
        <option>Level #2</option>
    </select>
    <input type="submit" name="Take">
</form>
</body>
</html>
