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
import java.sql.Date;

@WebServlet(urlPatterns = {Router.STORE_UPDATE})
public class StoreUpdateController extends HttpServlet {
    IStoreService storeService = new StoreServiceImpl();
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(SessionVar.STORE_OBJ) != null) {
                Store store = (Store) session.getAttribute(SessionVar.STORE_OBJ);
                User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
                req.setAttribute("store", store);
                req.setAttribute("user", user);
                req.setAttribute("update", true);
                req.getRequestDispatcher("/" + Router.S_INFO_PAGE).forward(req, resp);
            } else
                resp.sendRedirect(req.getContextPath() + Router.STORE_LOGIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(SessionVar.STORE_OBJ) != null) {
                Store store = (Store) session.getAttribute(SessionVar.STORE_OBJ);
                User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
                store.setUpdateDate(new Date(new java.util.Date().getTime()));
                store.setName(req.getParameter("name"));
                store.setBio(req.getParameter("bio"));
                store.setActive(Boolean.parseBoolean(req.getParameter("active")));
                user.setPhone(req.getParameter("phone"));
                user.setEmail(req.getParameter("email"));
                //update
                userService.updateUser(user);
                storeService.updateStore(store);
                resp.sendRedirect(req.getContextPath() + Router.STORE_INFO);
            } else
                resp.sendRedirect(req.getContextPath() + Router.STORE_LOGIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
