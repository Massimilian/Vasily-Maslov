package ru.job4j.planner.plannerservlets;

import ru.job4j.planner.Task;
import ru.job4j.planner.TaskStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.sendRedirect(String.format("%s/editor.jsp", req.getContextPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        TaskStorage.getInstance().setResult(TaskStorage.getInstance().edit(Integer.valueOf(req.getParameter("id")), new Task(req.getParameter("info"), Integer.valueOf(req.getParameter("urgency")))));
        this.doGet(req, resp);
    }
}
