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
        PrintWriter printwriter = new PrintWriter(resp.getOutputStream()); // готовим printWriter
        printwriter.append("My servlet works with " + this.users); // выводим данные из users, которые мы в предыдущем методе (doPost()) получили в List.
        printwriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // метод по добавлению и редактированию данных
        resp.setContentType("text/html");
        this.users.add(req.getParameter("login")); // добавляем в users данные, введённые в параметре login
        this.doGet(req, resp); // переходим в doGet()
    }
}
