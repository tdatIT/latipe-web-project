package com.webproject.controller.user;

import com.webproject.model.Cart;
import com.webproject.model.User;
import com.webproject.service.ICartItemsService;
import com.webproject.service.ICartService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.CartItemsServiceImpl;
import com.webproject.service.impl.CartServiceImpl;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/my-order"})
public class OrderController  extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    ICartItemsService cartItemsService = new CartItemsServiceImpl();
    ICartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute(SessionVar.USER_ID) == null){
            resp.sendRedirect(req.getContextPath() +"/login");
            return;
        }
        findAll(req, resp);
        req.getRequestDispatcher("/view/user/order.jsp").forward(req, resp);
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
            session.setAttribute("orders", user.getOrdersByUserId());


        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
