package ru.job4j.access;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/access/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("level").equals("Level #1")) {
            resp.sendRedirect(String.format("%s/accesspageone", req.getContextPath()));
        } else if (req.getParameter("level").equals("Level #2")) {
            resp.sendRedirect(String.format("%s/accesspagetwo", req.getContextPath()));
        } else {
            System.out.println("Unknown mistake");
        }
    }
}
