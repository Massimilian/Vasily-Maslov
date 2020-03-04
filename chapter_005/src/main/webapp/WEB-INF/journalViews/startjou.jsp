<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09.11.2019
  Time: 0:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Electronic journal</title>
</head>
<body>
<table border="1">
    <tr style="background-color: aqua">
        <th> Pupil name</th>
        <th> Last change time</th>
    </tr>
    <tr style="background-color: lightgreen">
        <c:forEach items="${pupils}" var="pupil">
    <tr>
        <th><c:out value="${pupil[0]}"></c:out></th>
        <th><c:out value="${pupil[1]}"></c:out></th>
        <th><c:out value="${pupil[2]}"></c:out></th>
        <th><c:out value="${pupil[3]}"></c:out></th>
    </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
