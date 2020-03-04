package ru.job4j.access;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessPageOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/access/levelOne.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("one").equals("ONE")) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("one", "ONE");
            }
            resp.sendRedirect(String.format("%s/accesscheck", req.getContextPath()));
        } else {
            req.setAttribute("error", "Invalid text! Enter \"ONE\", please!");
            doGet(req, resp);
        }
    }
}
