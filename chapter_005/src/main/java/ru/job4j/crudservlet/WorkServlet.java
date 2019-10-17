package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WorkServlet extends FatherServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "</head>"
                + "<body>"
                + "<form action='"
                + req.getContextPath()
                + "/main.jsp'"
                + "method='post'>"
                + this.controller.getInfo() + // запрашиваем результат работы.
                // Вопрос: можно ли, не делая контроллер статическим классом, обратиться к нему через jsp?
                // Это - единственная причина, почему не удалось засунуть весь метод doGet в jsp.
                "<input type='submit'>"
                + ""
                + "</form>"
                + "</body>"
                + "</html>");
        pw.flush();
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
        controller.works(sb.toString());
        this.doGet(req, resp);
    }
}
