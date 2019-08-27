package ru.job4j.servtests;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestSecondServlet extends FatherServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder();
        sb.append("<tr><td>"); // создаём заголовок
        sb.append("Number");
        sb.append("</td><td>");
        sb.append("Name");
        sb.append("</td><td>");
        sb.append("Surname");
        sb.append("</td><td>");
        sb.append("Place for button");
        sb.append("</td></tr>");
        for (int i = 0; i < single.getNames().size(); i++) {
            sb.append("<tr><td>"); // создаём "тело"
            sb.append(i + 1);
            sb.append("</td><td>");
            sb.append(single.getNames().get(i).getName());
            sb.append("</td><td>");
            sb.append(single.getNames().get(i).getSurname());
            sb.append("</td><td>");
            sb.append("<form action='" + //создаём кнопку для, например редактирования. Но каким образом можно переместить данные для редактирования в новый сервлет?
                    req.getContextPath() +
                    "/test'" + // пока - по умолчанию - возвращаемся на предыдущую страницу
                    "method='post'>" +
                    "<input type='submit'>" +
                    "</form>");
            sb.append("</td></tr>");
        }
        pw.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "</head>" +
                "<body>" +
                "<table>" +
                sb +
                "</table>" +
                "<form action='" + // куда мы отправляем форму
                req.getContextPath() + // уточняем адрес нахождения сервлета
                "/test'" + // указатель на необходимый сервлет, куда мы переходим при нажатии на кнопку
                "method='post'>" + // метод сервлета, который будет обрабатывать запрос (в данном случае post)
                "<input type='submit'>" + // кнопка ввода
                "</form>" +
                "</body>" +
                "</html>");
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("login");
        String surname = req.getParameter("anotherlogin");
        single.getNames().add(new Person(name, surname));
        doGet(req, resp);
    }
}
