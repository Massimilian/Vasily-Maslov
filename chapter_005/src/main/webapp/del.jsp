<%@ page import="ru.job4j.planner.TaskStorage" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14.10.2019
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planner-delete</title>
    <style>
        p {
            font-size: 40px;
        }
    </style>
</head>
<body>
<form action="<%=request.getContextPath()%>/start" method="post">
    <%if (TaskStorage.getInstance().isResult()) {%>
    <p style="color: green">Delete complite! </p>
    <%} else {%>
    <p style="color: red">Impossible! </p>
    <%}%>
    <input type="submit">
</form>
</body>
</html>
