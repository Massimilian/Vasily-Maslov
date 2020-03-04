<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.02.2020
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Level #2 accessed!</title>
</head>
<body style="background-color: blue">
<h1 style="color: deeppink">You have level #2 access!</h1>
<form action="${pageContext.servletContext.contextPath}/accessmain" method="get">
    <input type="submit" name="back">
</form>
</body>
</html>
