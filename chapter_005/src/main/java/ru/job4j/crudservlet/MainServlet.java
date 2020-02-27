package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends FatherServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", DBStore.getInstance().getList());
        req.getRequestDispatcher("/WEB-INF/storageViews/main.jsp").forward(req, resp);
    }
}
