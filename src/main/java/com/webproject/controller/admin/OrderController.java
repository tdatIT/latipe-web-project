package com.webproject.controller.admin;


import com.webproject.model.Orders;
import com.webproject.service.IOrderService;
import com.webproject.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/admin/transaction", "/admin/transaction/create", "/admin/transaction/update",
        "/admin/transaction/edit", "/admin/transaction/delete"})
public class OrderController extends HttpServlet {
    IOrderService com = new OrderServiceImpl();

    public OrderController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("edit")) {
            doPost(req, resp);
            return;
        }
        findAll(req, resp);
        req.getRequestDispatcher("/view/admin/transaction.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("edit")) {
            setStatus(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/transaction");
    }

    protected void setStatus(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String orderId = req.getParameter("orderId");
            int status = Integer.parseInt(req.getParameter("status"));
            com.setStatus(Integer.parseInt(orderId), status);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int status = req.getParameter("status") != null ? Integer.parseInt(req.getParameter("status")) : 0;
            String search = req.getParameter("search") != null ? req.getParameter("search") : "";
            int page = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 0;
            HashMap<Integer, Object> list = com.paginate(search, page, status);

            Map.Entry<Integer, Object> entry = list.entrySet().iterator().next();
            int size = entry.getKey();
            List<Orders> orders =  ( List<Orders>) entry.getValue();
            int endPage = size / 10;
            if (size % 3 != 10 && size > 10) {
                endPage++;
            }endPage = endPage > 0 ? endPage - 1 : endPage;
            req.setAttribute("endPage", endPage);
            req.setAttribute("orders", orders);
            req.setAttribute("tag", page);
            req.setAttribute("search", search);
            req.setAttribute("option", status);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }


}
