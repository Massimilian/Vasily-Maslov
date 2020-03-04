package ru.job4j.crudservlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CrudAdminAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getRequestURI().contains("/admincrudsignin")) {
            filterChain.doFilter(req, resp);
        } else {
            HttpSession session = req.getSession();
            synchronized (session) {
                if (session.getAttribute("admin") == null) {
                    resp.sendRedirect(String.format("%s/admincrudsignin", req.getContextPath()));
                    return;
                }
            }
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
