package com.webproject.controller.filter;


import com.webproject.service.IUserService;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.variable.RoleConst;
import com.webproject.variable.Router;
import com.webproject.variable.SessionVar;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {Router.STORE_FILTER + "/*"})
public class VendorFilter implements Filter {
    private IUserService service;
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        service = new UserServiceImpl();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String url = req.getRequestURI();
        HttpSession session = req.getSession();
        if (url.startsWith(req.getContextPath() + Router.STORE_FILTER)) {
            if (session.getAttribute(SessionVar.ROLE_ID) != null) {
                int user_role_id = (Integer) session.getAttribute(SessionVar.ROLE_ID);
                if (user_role_id == RoleConst.VENDOR &&
                        session.getAttribute(SessionVar.STORE_ID) != null) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    resp.sendRedirect(req.getContextPath() + Router.STORE_LOGIN + "?message=no");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + Router.STORE_LOGIN + "?message=no");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
