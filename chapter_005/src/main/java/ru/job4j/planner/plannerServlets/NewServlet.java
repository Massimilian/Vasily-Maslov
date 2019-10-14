package ru.job4j.planner.plannerServlets;

import ru.job4j.planner.Task;
import ru.job4j.planner.TaskStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.sendRedirect(String.format("%s/new.jsp", req.getContextPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        TaskStorage.getInstance().add(new Task(req.getParameter("info"), Integer.valueOf(req.getParameter("urgency"))));
        this.doGet(req, resp);
    }
}
