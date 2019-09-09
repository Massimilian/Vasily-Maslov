<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="ru.job4j.servlets.UserStorage" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 07.09.2019
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testing area</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/echo" method="post">
    Login: <input type="text" name="login"><br/>
    Email: <input type="text" name="email"><br/>
    <input type="submit">
</form>
<br/>
<table style="border: 1px solid darkblue" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>Login</th>
        <th>Email</th>
    </tr>
    <%for (User user : UserStorage.getInstance().getUsers()) {%>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>
