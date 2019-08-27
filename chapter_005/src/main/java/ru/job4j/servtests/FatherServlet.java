package ru.job4j.servtests;

import javax.servlet.http.HttpServlet;

public class FatherServlet extends HttpServlet {
    Singletone single = Singletone.getInstance();
}
