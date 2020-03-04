package ru.job4j.vocabulary;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OkServlet extends HttpServlet {

    private String result;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WordStorage.getInstance().setAdd(false);
        WordStorage.getInstance().setDelete(false);
        req.setAttribute("result", result);
        req.getRequestDispatcher("WEB-INF/vocabulary_views/ok.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        result = "Unknown mistake...";
        if (WordStorage.getInstance().isAdd()) {
            String word = req.getParameter("english");
            String translate = req.getParameter("russian");
            WordStorage.getInstance().add(word, translate);
            System.out.println("Add is working");
            result = "New word added.";
        }
        if (WordStorage.getInstance().isDelete()) {
            String word = req.getParameter("word");
            WordStorage.getInstance().delete(word);
            System.out.println("Delete is working");
            result = "The incorrect word deleted";
        }
        this.doGet(req, resp);
    }
}
