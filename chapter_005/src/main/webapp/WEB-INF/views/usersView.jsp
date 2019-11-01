<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testing area</title>
</head>
<body>
<!--... Было до jstl -->
<!--<form action=" %=request.getContextPath()% /" method="post"> -->
<!--... Стало с jstl -->
<form action="${pageContext.servletContext.contextPath}/" method="post">
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
    <!-- Ранее в сервлете UserController мы уже записали в объект request некие данные.
    Теперь здесь мы можем их вынуть при помощи метода getAttribute("имя") -->
    <!--... Было до jstl -->
    <!-- % for (User user : (List<User>) request.getAttribute("users")) {% -->
    <!--... Стало с jstl -->
    <c:forEach items="${users}" var="user">
    <tr>
        <!--... было до jstl -->
        <!--<td> %=user.getName()% </td> -->
        <!--... Стало с jstl -->
        <td><c:out value="${user.name}"></c:out></td>
        <!--... было до jstl -->
        <!--<td> %=user.getEmail()%  -->
        <!--... Стало с jstl -->
        <td><c:out value="${user.email}"></c:out></td>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>