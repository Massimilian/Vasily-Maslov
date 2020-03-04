<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.02.2020
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access check</title>
</head>
<body>
<p>Here is a page for checking your access. Here's two buttons</p>
<p style="color: blue"> Level #1</p>
<form action="${pageContext.servletContext.contextPath}/accesslevelone" method="post">
    <input type="submit" value="GO!">
</form>
<p style="color: deeppink"> level #2</p>
<form action="${pageContext.servletContext.contextPath}/accessleveltwo" method="get">
    <input type="submit" value="GO!">
</form>
</body>
</html>
