package com.webproject.controller.vendor;

import com.webproject.model.Store;
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

@WebServlet(urlPatterns = {Router.STORE_INFO})
public class StoreInfoController extends HttpServlet {
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            if (session.getAttribute(SessionVar.STORE_OBJ) != null) {
                Store store = (Store) session.getAttribute(SessionVar.STORE_OBJ);
                User user = userService.findById(store.getOwnId());
                req.setAttribute("store", store);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/" + Router.S_INFO_PAGE).forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + Router.STORE_D);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
