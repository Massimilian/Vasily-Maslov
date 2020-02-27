package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WorkServlet extends FatherServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("info", this.controller.getInfo());
        req.getRequestDispatcher("/WEB-INF/storageViews/work.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        sb.append(this.logic.getCommand());
        sb.append(controller.getSeparator());
        if (this.logic.getCommand().equals("update") || this.logic.getCommand().equals("delete")) {
            checkWork(req, resp);
            sb.append(req.getParameter("id"));
            sb.append(controller.getSeparator());
        }
        sb.append(req.getParameter("name"));
        sb.append(controller.getSeparator());
        sb.append(req.getParameter("login"));
        sb.append(controller.getSeparator());
        sb.append(req.getParameter("mail"));
        this.doGet(req, resp);
    }

    public void checkWork(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        if (Long.parseLong(req.getParameter("id")) != DBStore.getInstance().findUserIdByLogin(session.getAttribute("login").toString())) {
            resp.sendRedirect(String.format("%s/attencion", req.getContextPath()));
        }
    }
}
