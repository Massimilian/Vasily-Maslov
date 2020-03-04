<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 13.02.2020
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Check your knowledge</title>
</head>
<body>
<h1> Now let us check your knowledge of your vocabulary!</h1>
<c:out value="${result}"></c:out>
<h2> Enter the correct English words:</h2>
<form action="${pageContext.servletContext.contextPath}/vocabularychecking" method="post">
    <c:out value="${word.value}: "></c:out>
    <input type="text" name="answer">
    <input type="submit" value="go!">
</form>
</body>
</html>
