package ru.job4j.servtests;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends FatherServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "</head>" +
                "<body>" +
                "<form action='" + // куда мы отправляем форму
                req.getContextPath() + // уточняем адрес нахождения сервлета
                "/second'" + // указатель на необходимый сервлет
                "method='post'>" + // метод сервлета, который будет обрабатывать запрос (в данном случае post)
                "Name : " + // прописываем имя
                "<input type='text'" + // прописываем тип вводимой в окно информации
                "name='login'/>'" + // записываем имя
                //"<input type='submit'>" + // кнопка ввода
                "Surname : " +
                "<input type='text'" +
                "name='anotherlogin'/>'" +
                "<input type='submit'>" + // кнопка ввода
                "</form>" +
                "</body>" +
                "</html>");
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        doGet(req, resp);
    }
}
