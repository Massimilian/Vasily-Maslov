package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends FatherServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.logic.setCommand("delete");
        req.getRequestDispatcher("/WEB-INF/storageViews/delete.jsp").forward(req, resp);
    }
}
