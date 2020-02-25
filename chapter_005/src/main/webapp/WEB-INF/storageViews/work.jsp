<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 30.10.2019
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Working status</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/main" method="get">
    <c:out value="${info}"></c:out>
    <input type='submit' value='back'>
</form>
</body>
</html>