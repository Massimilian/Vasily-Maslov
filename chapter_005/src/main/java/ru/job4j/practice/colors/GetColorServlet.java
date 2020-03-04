package ru.job4j.practice.colors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetColorServlet extends HttpServlet {
    int red = 0;
    int green = 0;
    int blue = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.setColor(req.getParameter("red")));
        sb.append(this.setColor(req.getParameter("green")));
        sb.append(this.setColor(req.getParameter("blue")));
        sb.insert(0, "#");
        StringBuilder sbText = new StringBuilder();
        sbText.append(this.setAnotherColor(req.getParameter("red")));
        sbText.append(this.setAnotherColor(req.getParameter("green")));
        sbText.append(this.setAnotherColor(req.getParameter("blue")));
        sbText.insert(0, "#");
        req.setAttribute("color", sb.toString());
        req.setAttribute("textColor", sbText.toString());
        req.getRequestDispatcher("/WEB-INF/colorsViews/getcolor.jsp").forward(req, resp);
    }

    private String setColor(String forPreparate) {
        StringBuilder result = new StringBuilder();
        if (forPreparate.matches("[\\d]+") && Integer.valueOf(forPreparate) < 100) {
            if (forPreparate.length() < 2) {
                result.append(forPreparate);
                result.insert(0, "0");
            } else {
                result.append(forPreparate);
            }
        } else {
            result.append("00");
        }
        return result.toString();
    }

    private String setAnotherColor(String forPreparate) {
        String result = "00";
        if (Integer.valueOf(this.setColor(forPreparate)) < 30) {
            result = "59";
        }
        if (Integer.valueOf(this.setColor(forPreparate)) > 60) {
            result = "30";
        }
        return result;
    }
}
