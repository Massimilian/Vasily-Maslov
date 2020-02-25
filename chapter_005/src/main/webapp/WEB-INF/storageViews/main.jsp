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
<form action="${pageContext.servletContext.contextPath}/add.adm" method="post">
    <input type="submit" value="Add new">
</form>
<form action="${pageContext.servletContext.contextPath}/edit.adm" method="post">
    <input type="submit" value="Edit">
</form>
<form action="${pageContext.servletContext.contextPath}/delete.adm" method="post">
    <input type="submit" value="Delete">
</form>
<form action="${pageContext.servletContext.contextPath}/profileedit" method="post">
    <input type="submit" value="Don't press!">
</form>
<form action="${pageContext.servletContext.contextPath}/crudsignout">
    <input type="submit" value="Exit">
</form>
</body>
</html>
