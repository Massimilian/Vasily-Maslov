package ru.job4j.for_delete;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // вызываем текущую сессию. false внутри конструктора не позволил бы создать новую сесcию.
        HttpSession session = req.getSession();
        // уничтожаем сессию.
        session.invalidate();
        // вызываем окно авторизации
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
    }
}
