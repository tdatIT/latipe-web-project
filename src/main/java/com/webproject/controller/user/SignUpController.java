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
import java.sql.Date;

@WebServlet(urlPatterns = {Router.SIGNUP})
public class SignUpController extends HttpServlet {
    private IUserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(SessionVar.USER_ID) == null) {
                req.getRequestDispatcher(Router.SIGNUP_PAGE).forward(req, resp);
            } else
                resp.sendRedirect(req.getContextPath() + Router.HOME);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(SessionVar.NAME_USER) == null) {
                User us = new User();
                us.setLastname(req.getParameter("lastname"));
                us.setFirstname(req.getParameter("firstname"));
                us.setEmail(req.getParameter("email"));
                us.setHashedPassword(req.getParameter("password"));
                us.setPhone(req.getParameter("phone"));
                us.setIdCard(req.getParameter("id_card"));
                //set default value into object
                us.setAvatar("user.png");
                us.seteWallet(0.0);
                //get current date and cast from util.date to sql.date
                us.setCreateDate(new Date(new java.util.Date().getTime()));
                us.setRoleId(1);
                us.setStoreEmpId(null);
                us.setUserLevelId(1);
                us.setPoint(0);
                us.setEmailActive(false);
                us.setPhoneActive(false);
                //call service and insert new user
                if (service.insertNewUser(us)) {
                    req.setAttribute("status", true);
                    req.getRequestDispatcher(Router.LOGIN_PAGE).forward(req, resp);
                } else {
                    req.setAttribute("status", false);
                    req.getRequestDispatcher(Router.SIGNUP_PAGE).forward(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + Router.ERROR_404_PAGE);
        }
    }
}
