package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class UsersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // передача данных из сервлета в jsp-страницу.
        // Метод setAttribute(String, value) передаёт имя (строковое название данных) и
        // сами данные в jsp. Данные помещаются в обёртку HttpServletRequest
        // (и, таким образом, избавляемся от необходимости использовать синглетон UserStorage).
        // Парных значений может быть установлено несколько (имя + значение),
        // и все они будут упакованы в HttpServletRequest.
        req.setAttribute("users", UserStorage.getInstance().getUsers());
        // Вызываем напрямую код и записываем его в объект HttpServletRequest.
        // RequestContext тут не используется, поиск начинается сразу с папки WEB-INF.
        // Чтобы сделать перенаправление, нужно вызвать метод forward(),
        // который перешлёт HttpServletRequest и HttpServletResponse на нашу страницу.
        req.getRequestDispatcher("/WEB-INF/views/usersView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // В UserStorage мы добавляем новый объект User, который создаётся по ходу
        // путём вытаскивания значений login и email из пришедшего объекта типа HttpServletResponse
        UserStorage.getInstance().add(new User(req.getParameter("login"), req.getParameter("email")));
        // Идёт переброска на страницу jsp, которая обозначена в web как базовая (без дополнительного адреса)
        resp.sendRedirect(String.format("%s/ucont", req.getContextPath()));
    }
}
