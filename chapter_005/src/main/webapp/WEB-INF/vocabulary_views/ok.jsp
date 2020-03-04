<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.02.2020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Worked</title>
</head>
<body>
<c:out value="${result}"></c:out>
<form action="${pageContext.servletContext.contextPath}/vocabulary" method="get">
    <input type="submit" value="back">
</form>
</body>
</html>
