<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27.11.2019
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
    <div class="checkbox">
        <input type="file" name="file">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
