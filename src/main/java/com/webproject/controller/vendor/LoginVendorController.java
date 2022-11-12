package com.webproject.controller.vendor;

import com.webproject.model.Store;
import com.webproject.model.User;
import com.webproject.service.IStoreService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.StoreServiceImpl;
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
    private IUserService userService = new UserServiceImpl();
    private IStoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        if (session.getAttribute(SessionVar.STORE_ID) == null) {
            req.setAttribute("status", 1);
            req.getRequestDispatcher(Router.STORE_LOGIN_PAGE).forward(req, resp);
        } else
            resp.sendRedirect(req.getContextPath() + Router.STORE_D);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        if (session.getAttribute(SessionVar.STORE_ID) == null
                || session.getAttribute(SessionVar.USER_ID) == null) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if (userService.validate(email, password)) {
                //get user and store by user_id
                User us = userService.getUserByEmail(email);
                Store store = storeService.findByOwnId(us.getUserId());
                //set attb into session
                session.setAttribute(SessionVar.USER_ID, us.getUserId());
                session.setAttribute(SessionVar.NAME_USER, us.getLastname());
                session.setAttribute(SessionVar.ROLE_ID, us.getRoleId());
                session.setAttribute(SessionVar.STORE_ID, store.getStoreId());
                session.setAttribute(SessionVar.STORE_OBJ, store);
                //redirect dashboard page
                resp.sendRedirect(req.getContextPath() + Router.STORE_D);
            } else {
                req.setAttribute("status", 0);
                req.getRequestDispatcher(Router.STORE_LOGIN_PAGE).forward(req, resp);
            }
        } else {
            session.invalidate();
            req.getRequestDispatcher(Router.STORE_LOGIN_PAGE).forward(req, resp);
        }

    }
}
