package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EasyPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title</title>"
                + "</head>"
                + "<body>"
                + "<h1>"
                + "This is a title."
                + "</h1>"
                + "<span>"
                + "Текстовый отрывок. Why cannot I see Russian words?"
                + "</span>"
                + "</body>"
                + "</html>");
        writer.flush();
    }
}
