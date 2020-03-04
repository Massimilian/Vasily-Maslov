package ru.job4j.access.filteres;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilterOne implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getRequestURI().contains("/accesspageone")) {
            filterChain.doFilter(req, resp);
        } else {
            HttpSession session = req.getSession();
            synchronized (session) {
                if (session.getAttribute("one") == null || !session.getAttribute("one").equals("ONE")) {
                    resp.sendRedirect(String.format("%s/accesspageone", req.getContextPath()));
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
