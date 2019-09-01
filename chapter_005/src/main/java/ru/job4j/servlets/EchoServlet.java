package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class EchoServlet extends HttpServlet {
    private List<String> users = new CopyOnWriteArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printwriter = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder("<table>"); // тег для вывода на экран таблицы значений
        for (String login : this.users) {
            sb.append(
                    "<tr>" + // новая строка
                            "<td>" + // новая ячейка ввода
                            login +
                            "</td>" + // закрываем ячейку
                            "</tr>" // закрываем строку
            );
        }
        sb.append("</table>"); // закрытие тега вывода
        printwriter.append("<!DOCTYPE html>" + // прописываем тип документа (html-код)
                "<html lang=\"en\">" + // прописываем язык документа
                "<head>" + // прописываем "голову" - то есть то, что будет наверху
                "<meta charset=\"UTF-8\">" +
                "<title>Execise program</title>" + // прописываем название в теге title "голове"
                "</head>" + // закрываем "голову"
                "<body>" + // открываем тег "тела"
                "<form" + // открываем тег "форма" - элемент формы ввода
                " action='" + // URL, по которому будет происходить перенаправление заполненной формы
                req.getContextPath() + // уточнение адреса имени приложения
                "/echo'" + // указываем адрес сервлета, на который мы отправляемся
                " method='post'>" + // каким образом мы будем отправлять (в данном случае - методом post, т.е. при вводе отработает post)
                "Name: " + // название элементов ввода (будет отображено перед полем ввода)
                "<input type='text' " + // тип вводимой информации - текст
                "name='login'/>" + // имя вводимой информации - login
                "<input type='submit'>" + // кнопка, которая отправляет данные
                "</form>" + // закрываем тег "форма"
                "<br>" +
                sb +
                "</br>" +
                "</body>" + // закрываем тег "тела"
                "</html>"); // закрываем тег "html"
        printwriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.users.add(req.getParameter("login"));
        this.doGet(req, resp);
    }
}
