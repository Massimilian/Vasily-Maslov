package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserServlet extends HttpServlet {
    // Создаём коллекцию для хранения пользователей
    private List<User> users = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder("<table>");
        // Подготавливаем вывод всех пользователей
        for (User user : this.users) {
            sb.append("<tr><td>" + user.toString() + "</td></tr>");
        }
        sb.append("</table>");
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "</head>"
                + "<body>"
                + "<form action = '" + req.getContextPath() + "/crud' method='post'>"
                + "Name: <input type='text' name='login'>"
                + "<input type='submit'>"
                + "</form>"
                + "<br/>"
                + sb.toString()
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // Вводим в тестовом режиме двух новых пользователей, которых потом надо будет вывести на странице.
//        this.users.add(new User(1, "First", "first", "first@.com"));
//        this.users.add(new User(2, "Second", "second", "second@.com"));
        doGet(req, resp);
    }
}
