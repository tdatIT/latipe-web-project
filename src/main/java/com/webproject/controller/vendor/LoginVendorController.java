package com.webproject.controller.vendor;

import com.webproject.model.User;
import com.webproject.service.IUserService;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.variable.Router;
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {Router.STORE_LOGIN, Router.STORE_FILTER})
public class LoginVendorController extends HttpServlet {
    private IUserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        if (session.getAttribute(SessionVar.ROLE_ID) != null || session.getAttribute(SessionVar.USER_ID) != null) {
            int role_id = (Integer) session.getAttribute(SessionVar.ROLE_ID);
            if (role_id == 3) {
                resp.sendRedirect(req.getContextPath() + Router.STORE_D);
            } else {
                req.getRequestDispatcher(Router.STORE_LOGIN_PAGE).forward(req, resp);
            }

        } else
            req.getRequestDispatcher(Router.STORE_LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        if (session.getAttribute(SessionVar.ROLE_ID) == null
                && session.getAttribute(SessionVar.USER_ID) == null) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if (service.validate(email, password)) {
                User us = service.getUserByEmail(email);
                session.setAttribute(SessionVar.USER_ID, us.getUserId());
                session.setAttribute(SessionVar.NAME_USER, us.getLastname());
                session.setAttribute(SessionVar.ROLE_ID, us.getRoleId());
                resp.sendRedirect(req.getContextPath() + Router.STORE_D);
            } else {
                req.setAttribute("status", false);
                req.getRequestDispatcher(Router.STORE_LOGIN_PAGE).forward(req, resp);
            }
        } else {
            session.invalidate();
            req.getRequestDispatcher(Router.STORE_LOGIN_PAGE).forward(req, resp);
        }

    }
}
