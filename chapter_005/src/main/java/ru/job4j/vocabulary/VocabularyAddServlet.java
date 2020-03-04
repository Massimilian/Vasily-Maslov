package ru.job4j.vocabulary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VocabularyAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WordStorage.getInstance().setAdd(true);
        req.getRequestDispatcher("WEB-INF/vocabulary_views/add.jsp").forward(req, resp);
    }
}
