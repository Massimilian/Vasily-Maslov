<%@ page import="ru.job4j.planner.Task" %>
<%@ page import="ru.job4j.planner.TaskStorage" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.10.2019
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planner</title>
    <style>
        table, td, th {
            border: 1px solid black;
            border-collapse: collapse;
        }

        p {
            font-size: 20px;
            font-family: Consolas;
            background-color: beige;
        }
    </style>
</head>
<body style="background-color: aliceblue">
<h1> Welcome to the simple planner!</h1><br>
<h2> Your tasks:</h2>
<table>
    <tr style=" background-color: lightsteelblue">
        <th>ID number</th>
        <th>Information</th>
        <th>Create date</th>
    </tr>
    <% ArrayList<Task> tasks = TaskStorage.getInstance().asList();
        if (tasks.size() == 0) {%>
    <h5> ....... you have not tasks.</h5>
    <%}%>
    <%
        for (Task task : tasks) {
    %>

    <tr style="background-color: <%=TaskStorage.getInstance().chosedColor(task.getUrgency())%>">
        <td><%=task.getNumber()%>
        </td>
        <td><%=task.getInfo()%>
        </td>
        <td><%=task.getCreateDate()%>
        </td>
    </tr>
    <%
        }%>
</table>
<p>Add new :</p>
<form action="<%=request.getContextPath()%>/new" method="post">
    Enter task information:
    <input type="text" name="info">
    Enter task urgency(1 - 7):
    <input type="text" name="urgency">
    <input type="submit">
</form>
<p>Edit:</p>
<form action="<%=request.getContextPath()%>/editor" method="post">
    Enter id-number of the task for add:
    <input type="text" name="id">
    Enter new task information:
    <input type="text" name="info">
    Enter new task urgency(1 - 7):
    <input type="text" name="urgency">
    <input type="submit">
</form>
<p>Delete :</p>
<form action="<%=request.getContextPath()%>/del" method="post">
    Enter id-number of the task for delete:
    <input type="text" name="id">
    <input type="submit">
</form>

</body>
</html>
