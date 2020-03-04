package ru.job4j.for_delete;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // необходимо сделать приведение типов request - к HttpServletRequest, response - к HttpServletResponse.
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // необходимо проверить, не находимся ли мы уже на странице авторизации (чтобы не зациклить проверку). Для этого проверим URL запроса.
        if (req.getRequestURI().contains("/signin")) {
            // Если URL содержится в запросе - то просто переходим на страницу авторизации
            chain.doFilter(request, response);
            // иначе осущестляем проверку существования сессии
        } else {
            HttpSession session = req.getSession();
            synchronized (session) {
                // если параметр login внутри существующей сессии не существует
                if (session.getAttribute("login") == null) {
                    // делаем redirect (перенаправление) на страницу с авторизацией - т.е. на сервлет SignIn
                    resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
                    // выходим из фильтра
                    return;
                }
            }
            // Если условие if не отработало, мы можем выходить из фильтра и двигаться дальше по запросу пользователя.
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
