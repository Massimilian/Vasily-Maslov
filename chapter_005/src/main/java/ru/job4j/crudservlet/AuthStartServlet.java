package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthStartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/storageViews/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("role").equals("Admin")) {
            req.getRequestDispatcher("WEB-INF/storageViews/admincrudsignin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/storageViews/crudsignin.jsp").forward(req, resp);
        }
    }
}
