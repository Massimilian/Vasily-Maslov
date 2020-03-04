package ru.job4j.vocabulary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VocabularyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("words", WordStorage.getInstance().getWords());
        req.getRequestDispatcher("WEB-INF/vocabulary_views/main.jsp").forward(req, resp);
    }
}
