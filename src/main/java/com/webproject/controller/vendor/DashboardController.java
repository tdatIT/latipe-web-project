package com.webproject.controller.vendor;

import com.webproject.service.IOrderService;
import com.webproject.service.IStoreService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.OrderServiceImpl;
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
import java.util.Map;

@WebServlet(urlPatterns = {Router.STORE_D})
public class DashboardController extends HttpServlet {

    IUserService userService = new UserServiceImpl();
    IStoreService storeService = new StoreServiceImpl();
    IOrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            int user_id = (Integer) session.getAttribute(SessionVar.USER_ID);
            int store_id = (Integer) session.getAttribute(SessionVar.STORE_ID);
            Map<Integer, Long> chart_data_1 = orderService
                    .totalOrdersFromStore5Month(store_id, new Date(new java.util.Date().getTime()));
            Map<Integer, Double> chart_data_2 = orderService
                    .totalAmountsFromStore5Month(store_id, new Date(new java.util.Date().getTime()));
            Map<String, Long> chart_data_3 = orderService
                    .totalProductInMonth(store_id, new Date(new java.util.Date().getTime()));
            int num_emp = userService.findByStore(store_id).size();
            req.setAttribute("numEmp", num_emp);
            req.setAttribute("chart_data_1", chart_data_1);
            req.setAttribute("chart_data_2", chart_data_2);
            req.setAttribute("chart_data_3", chart_data_3);
            req.getRequestDispatcher("/" + Router.STORE_DASHBOARD).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
