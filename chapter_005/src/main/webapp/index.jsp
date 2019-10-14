<%@ page import="ru.job4j.crudservlet.User" %>
<%@ page import="ru.job4j.crudservlet.ValidServ" %>
<%@ page import="ru.job4j.crudservlet.DBStore" %><%--
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
    <%for (User user : DBStore.getInstance().getList()) {%>
    <tr style="background-color:<%=ValidServ.getValidateService().getColor().get()%>">
        <td><%=user.getId()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getLogin()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td><%=user.getCreateDate()%>
        </td>
    </tr>
    <%}%>
</table>
Add new :
<form action="<%=request.getContextPath()%>/add" method="post">
    <input type="submit">
</form>
Edit :
<form action="<%=request.getContextPath()%>/edit" method="post">
    <input type="submit">
</form>
Delete :
<form action="<%=request.getContextPath()%>/delete" method="post">
    <input type="submit">
</form>
</body>
</html>
