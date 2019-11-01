<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09.09.2019
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CrudServlet</title>
</head>
<body>
<table border="1">
    <tr style="background-color: yellow">
        <th>ID number</th>
        <th>Name</th>
        <th>Login</th>
        <th>Mail address</th>
        <th>Last change</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr style="background-color:lightgreen">
            <td><c:out value="${user.id}"></c:out>
            </td>
            <td><c:out value="${user.name}"></c:out>
            </td>
            <td><c:out value="${user.login}"></c:out>
            </td>
            <td><c:out value="${user.email}"></c:out>
            </td>
            <td><c:out value="${user.createDate}"></c:out>
            </td>
        </tr>
    </c:forEach>
</table>
Add new :
<form action="${pageContext.servletContext.contextPath}/add" method="post">
    <input type="submit">
</form>
Edit :
<form action="${pageContext.servletContext.contextPath}/edit" method="post">
    <input type="submit">
</form>
Delete :
<form action="${pageContext.servletContext.contextPath}/delete" method="post">
    <input type="submit">
</form>
</body>
</html>
