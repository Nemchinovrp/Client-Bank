package com.becomejavasenior.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession();
        if (("/login.jsp").equals(uri) || ("/error.jsp").equals(uri) || ("/LoginServlet").equals(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        if (session != null && session.getAttribute("role") != null) {
           /* Role role = Role.fromString((String) session.getAttribute("role"));*/
            if (uri.startsWith("/Admin")&&("ADMIN").equals(session.getAttribute("role"))) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (uri.startsWith("/Client")&&("CLIENT").equals(session.getAttribute("role"))) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (uri.startsWith("/Paymaster")&&("PAYMASTER").equals(session.getAttribute("role"))) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            res.sendRedirect("/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
