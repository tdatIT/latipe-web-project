package com.webproject.controller.admin;

import com.webproject.service.IOrderService;
import com.webproject.service.IProductService;
import com.webproject.service.IStoreService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.OrderServiceImpl;
import com.webproject.service.impl.ProductServiceImpl;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@WebServlet(urlPatterns = {Router.STORE_D})
public class DashboardController extends HttpServlet {

    IUserService userService = new UserServiceImpl();
    IStoreService storeService = new StoreServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    IProductService prodService = new ProductServiceImpl();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            int user_id = (Integer) session.getAttribute(SessionVar.USER_ID);

            String option = req.getParameter("option") != null ? req.getParameter("option") : "0";
            String optionNewShop = req.getParameter("id") != null ? req.getParameter("id") : "-1";
            String optionNewUser = req.getParameter("id") != null ? req.getParameter("id") : "-1";
            String optionProfit = req.getParameter("id") != null ? req.getParameter("id") : "-1";
            Date date = req.getParameter("date") != null ?  formatter.parse(req.getParameter("date")) : null;

            req.getRequestDispatcher("/" + Router.ADMIN_DASHBOARD).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
