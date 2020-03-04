package ru.job4j.for_delete;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    // этот get-метод будет вызываться при вызове URL /fordel.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // добавляем атрибут в Request, который мы потом будем вызывать на странице .jsp (View)
        req.setAttribute("users", UserStorage.getInstance().getUsers());
        // напрямую вызываем страницу userViewSecond.jsp (которая находится в папке WEB-INF), далее метод forward() перебрасывает данные дальше.
        req.getRequestDispatcher("/WEB-INF/views/userViewSecond.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // здесь мы получаем данные из request и добавляем их в хранилище
        UserStorage.getInstance().add(new User(req.getParameter("login"), req.getParameter("mail"), null));
        // возвращаемся на нашу страницу. Обращаем внимание, что теперь вызов осуществляется по URL.
        resp.sendRedirect(String.format("%s/fordel", req.getContextPath()));
        // то есть, фактически, мы можем прямо из этого места обратиться к нашему сервлету и вызвать метод this.doGet(req, resp); результат будет тот же
    }
}
