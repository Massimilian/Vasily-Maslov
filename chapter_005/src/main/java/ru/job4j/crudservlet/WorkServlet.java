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
            sb.append(req.getParameter("id"));
            sb.append(controller.getSeparator());
        }
        sb.append(req.getParameter("name"));
        sb.append(controller.getSeparator());
        sb.append(req.getParameter("login"));
        sb.append(controller.getSeparator());
        sb.append(req.getParameter("mail"));
        if (isAdmin(req)) {
            controller.works(sb.toString());
        } else {
            if (this.logic.getCommand().equals("add")) {
                this.controller.setInfo("Access problems. Enter your valid login and try again.");
            } else if (checkWork(req)) {
                renovateSession(req);
                controller.works(sb.toString());
            } else {
                this.controller.setInfo("Access problems. Enter your valid login and try again.");
            }
        }
        this.doGet(req, resp);
    }

    private boolean checkWork(HttpServletRequest req) throws IOException {
        boolean result = true;
        HttpSession session = req.getSession();
        System.out.println(Long.parseLong(req.getParameter("id")));
        System.out.println(DBStore.getInstance().findUserIdByLogin(session.getAttribute("login").toString()));
        if (Long.parseLong(req.getParameter("id")) != DBStore.getInstance().findUserIdByLogin(session.getAttribute("login").toString())) {
            result = false;
        }
        return result;
    }

    private void renovateSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        synchronized (session) {
            session.setAttribute("login", req.getParameter("login"));
        }
    }

    private boolean isAdmin(HttpServletRequest req) {
        HttpSession session = req.getSession();
        boolean result = false;
        if (session.getAttribute("admin") != null) {
            result = session.getAttribute("login").equals("admin") && session.getAttribute("admin").equals("admin");
        }
        return result;
    }
}
