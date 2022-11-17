package com.webproject.controller.vendor;

import com.webproject.model.OrderItems;
import com.webproject.model.Orders;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {Router.STORE_O_P})
public class OrderProcessController extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            if (req.getParameter("orderId") != null) {
                Orders order = orderService.findById(
                        Integer.parseInt(req.getParameter("orderId")));
                if (order.getStoreId() == (Integer) session.getAttribute(SessionVar.STORE_ID)) {
                    req.setAttribute("order", order);

                    List<OrderItems> items = new ArrayList<>(order.getOrderItemsByOrderId());
                    req.setAttribute("items", items);
                    req.getRequestDispatcher("/" + Router.S_ORDER_P).forward(req, resp);
                } else
                    resp.sendRedirect(req.getContextPath() + Router.ERROR404);
            } else {
                resp.sendRedirect(req.getContextPath() + Router.STORE_O);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            if (req.getParameter("orderId") != null) {
                Orders order = orderService.findById(
                        Integer.parseInt(req.getParameter("orderId")));
                if (order.getStoreId() == (Integer) session.getAttribute(SessionVar.STORE_ID)) {
                    order.setStatus(Integer.parseInt(req.getParameter("status")));
                    orderService.updateOrder(order);
                    resp.sendRedirect(req.getContextPath() + Router.STORE_O);
                } else
                    resp.sendRedirect(req.getContextPath() + Router.ERROR404);
            } else {
                resp.sendRedirect(req.getContextPath() + Router.STORE_O);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
