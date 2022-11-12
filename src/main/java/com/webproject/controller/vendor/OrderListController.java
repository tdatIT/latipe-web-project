package com.webproject.controller.vendor;

import com.webproject.model.Orders;
import com.webproject.model.Store;
import com.webproject.service.IOrderService;
import com.webproject.service.impl.OrderServiceImpl;
import com.webproject.variable.Router;
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {Router.STORE_O})
public class OrderListController extends HttpServlet {
    private IOrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            if (session.getAttribute(SessionVar.STORE_OBJ) != null) {
                Store store = (Store) session.getAttribute(SessionVar.STORE_OBJ);
                List<Orders> orders = orderService.findByShopId(store.getStoreId());
                req.setAttribute("orders", orders);
                req.getRequestDispatcher("/" + Router.S_ORDER_M).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + Router.ERROR404);
        }
    }
}
