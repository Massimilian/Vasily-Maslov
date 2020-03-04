package ru.job4j.journal.servlets;

import ru.job4j.journal.Journal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartJournalServlet extends HttpServlet {
    String[][] test = new String[][]{{"Olga", "*", "*", ""}, {"Vasili", "*", "*", ""}};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("pupils", Journal.getInstance().prepareTable());
        req.setAttribute("pupils", test);
        req.getRequestDispatcher("/WEB-INF/journalViews/startjou.jsp").forward(req, resp);
    }
}