<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.02.2020
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Level #1 accesses!</title>
</head>
<body style="background-color: deeppink">
<h1 style="color: blue">You have level #1 access!</h1>
<form action="${pageContext.servletContext.contextPath}/accessmain" method="get">
    <input type="submit" name="back">
</form>
</body>
</html>
