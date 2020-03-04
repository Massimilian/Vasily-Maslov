package ru.job4j.for_delete;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // добавляем отрисовку нашего сервлета. Эта отрисовка будет выводиться в двух случаях: когда мы пришли сюда впервые (т.е. нас перебросило из сервлета UserServlet) и когда мы набрали неправильное сочетание login и password (тогда атрибуту error будет присвоено значение "Credentional invalid", и затем оно будет выведено в странице .jsp).
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получаем параметр login из Request
        String login = req.getParameter("login");
        // получаем параметр password из Request
        String password = req.getParameter("password");
        // проверяем,что такое сочетание пользователя и пароля реально существует. Если подобное сочетание встречается, тогда...
        if (UserStorage.getInstance().isCredentional(login, password)) {
            // возвращение сессии (ассоциации с конкретным пользователем). В принципе, сессия создаётся автоматически, но мы можем зафиксировать её искусственно. Этот метод создаёт сессию, если её ещё не существует, и возвращает, если она уже есть.
            HttpSession session = req.getSession();
            // сессию обязательно надо синхронизировать, так как она функционирует внутри сервлета, а сервлет работает в многопоточном режиме
            synchronized (session) {
                // устанавливаем внутри нашей сесии атрибут login
                session.setAttribute("login", login);
            }
            // далее мы перенаправляемся на нашу страницу, обрабатываемую сервлетом fordel (UserServlet). Таким образом мы реализовали "узнавание" пользователя системой.
            resp.sendRedirect(String.format("%s/fordel", req.getContextPath()));
        } else {
            // если подобное сочетание не встречается, тогда...
            // записываем новый атрибут error, который сообщает, что такого сочетания login и password не существует.
            req.setAttribute("error", "Credentional invalid");
            // перекидываем данные в get-метод. Там мы их просто отрисовываем с пометкой, что введённые данные неправильны (спасибо атрибуту error).
            doGet(req, resp);
        }
    }
}
