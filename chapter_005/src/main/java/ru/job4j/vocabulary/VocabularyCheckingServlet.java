package ru.job4j.vocabulary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VocabularyCheckingServlet extends HttpServlet {
    Word word = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        word = WordStorage.getInstance().getWord();
        req.setAttribute("word", word);
        req.getRequestDispatcher("WEB-INF/vocabulary_views/checking.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");
        if (word.getWord().equals(answer)) {
            req.setAttribute("result", "CORRECT!");
        } else {
            req.setAttribute("result", "INCORRECT!");
        }
        doGet(req, resp);
    }
}
