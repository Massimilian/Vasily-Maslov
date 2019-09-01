package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Presentation layout. Servlet. Showing the working area.
 */
public class CrudServlet extends FatherServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder();
        sb.append("<tr style=\"background-color: yellow\"><td>"); // создаём заголовок
        sb.append("ID number");
        sb.append("</td><td>");
        sb.append("Name");
        sb.append("</td><td>");
        sb.append("Login");
        sb.append("</td><td>");
        sb.append("Mail address");
        sb.append("</td><td>");
        sb.append("Last change");
        sb.append("</td></tr>");
        String[] colors = {"yellowgreen", "lightgreen"};
        int num = 0;
        for (int i = 0; i < this.logic.getList().size(); i++) {
            sb.append("<tr style=\"background-color: ");
            sb.append(colors[num++]);
            sb.append("\"><td>");
            sb.append(this.logic.getList().get(i).getId());
            sb.append("</td><td>");
            sb.append(this.logic.getList().get(i).getName());
            sb.append("</td><td>");
            sb.append(this.logic.getList().get(i).getLogin());
            sb.append("</td><td>");
            sb.append(this.logic.getList().get(i).getEmail());
            sb.append("</td><td>");
            sb.append(this.logic.getList().get(i).getCreateDate());
            sb.append("</td></tr>");
            num = num >= colors.length ? 0 : num;
        }
        pw.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "</head>" +
                "<body>" +
                "<table border=\"1\">" +
                sb +
                "</table>" +
                "Add new: " +
                "<form action='" + // куда мы отправляем форму
                req.getContextPath() + // уточняем адрес нахождения сервлета
                "/add'" + // указатель на необходимый сервлет, куда мы переходим при нажатии на кнопку
                "method='post'>" + // метод сервлета, который будет обрабатывать запрос (в данном случае post)
                "<input type='submit'>" + // кнопка ввода
                "</form>" +
                "Edit: " +
                "<form action='" +
                req.getContextPath() +
                "/edit'" +
                "method='post'>" +
                "<input type='submit'>" +
                "</form>" +
                "Delete: " +
                "<form action='" +
                req.getContextPath() +
                "/delete'" +
                "method='post'>" +
                "<input type='submit'>" +
                "</form>" +
                "</body>" +
                "</html>");
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.doGet(req, resp);
    }
}
