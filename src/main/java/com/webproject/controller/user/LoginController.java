package com.webproject.controller.user;

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

@WebServlet(urlPatterns = {Router.LOGIN})
public class LoginController extends HttpServlet {

    IUserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") == null) {
                req.getRequestDispatcher(Router.LOGIN_PAGE).forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + Router.HOME);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher(Router.ERROR_404_PAGE).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            //Get data in session and parameter in http request
            HttpSession session = req.getSession();
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            //Validate user account and redirect
            if (session.getAttribute("username") == null
                    && (email != null || password != null)) {
                if (service.validate(email, password)) {
                    User us = service.getUserByEmail(email);
                    session.setAttribute(SessionVar.USER_ID, us.getUserId());
                    session.setAttribute(SessionVar.NAME_USER, us.getLastname());
                    session.setAttribute(SessionVar.ROLE_ID, us.getRoleId());
                    resp.sendRedirect(req.getContextPath() + Router.HOME);
                } else {
                    req.setAttribute("status", false);
                    req.getRequestDispatcher(Router.LOGIN_PAGE).forward(req, resp);
                }
            } else
                resp.sendRedirect(req.getContextPath() + Router.HOME);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher(Router.ERROR_404_PAGE).forward(req, resp);
        }
    }
}
