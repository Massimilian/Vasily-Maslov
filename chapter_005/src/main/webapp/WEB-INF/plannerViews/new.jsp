<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 14.10.2019
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planner-new</title>
    <style>
        p {
            font-size: 40px;
            color: green;
        }
    </style>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/start" method="post">
    <p>New task added! </p>
    <input type="submit">
</form>

</body>
</html>
