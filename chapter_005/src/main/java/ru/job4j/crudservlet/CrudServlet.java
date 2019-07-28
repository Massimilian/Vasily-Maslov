package ru.job4j.crudservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Presentation layout. Servlet.
 */
public class CrudServlet extends HttpServlet {
    private final Store logic = ValidateService.getValidateService();
    private final Controller controller = new Controller(logic);
    String reg = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printwriter = new PrintWriter(resp.getOutputStream());
        printwriter.append(String.format("%s%s%s", controller.getInfo(), System.lineSeparator(), controller.report()));
        printwriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        reg = req.getParameter("action");
        this.controller.works(reg);
        this.doGet(req, resp);
    }

}
