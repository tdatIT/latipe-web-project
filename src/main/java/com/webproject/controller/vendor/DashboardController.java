package com.webproject.controller.vendor;

import com.webproject.model.Store;
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

@WebServlet(urlPatterns = {Router.STORE_D})
public class DashboardController extends HttpServlet {

    IUserService userService = new UserServiceImpl();
    IStoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            int user_id = (Integer) session.getAttribute(SessionVar.USER_ID);
            req.getRequestDispatcher("/" + Router.STORE_DASHBOARD).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
