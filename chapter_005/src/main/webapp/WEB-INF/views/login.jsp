<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<!-- работаем с тегом c:if. Здесь мы проверяем, в каком состоянии у нас атрибут error-->
<!-- Если атрибут error не равен пустоте...-->
<c:if test="${error != ''}">
    <!-- тег div - для вывода простого текста-->
    <!-- атрибут style позволяет поменять стиль отображения. В данном случае добавлен красный задний фон.-->
    <div style="background-color: red">
        <!-- при помощи тега c:out выводим значения атрибута error на экран-->
        <c:out value="${error}"></c:out>
    </div>
</c:if>
<!-- Стандартная форма по отправке сведений-->
<form action="${pageContext.servletContext.contextPath}/signin" method="post">
    <p>Login</p>
    <input type="text" name="login"><br/>
    <p>Password</p>
    <!-- ВНИМАНИЕ! Новый вид атрибута type - password (выводит звёздочки вместо вводимых символов)-->
    <input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
