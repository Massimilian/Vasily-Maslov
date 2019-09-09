package ru.job4j.crudservlet;

import javax.servlet.http.HttpServlet;

public class FatherServlet extends HttpServlet {
    protected final Store logic = ValidServ.getValidateService();
    protected final Controller controller = new Controller(logic);
}
