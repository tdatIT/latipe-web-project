package com.webproject.controller.user;

import com.webproject.model.Cart;
import com.webproject.model.User;
import com.webproject.service.*;
import com.webproject.service.impl.*;
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart", "/cart/delete",})
public class CartController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    ICartItemsService cartItemsService = new CartItemsServiceImpl();
    ICartService cartService = new CartServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute(SessionVar.USER_ID) == null){
            resp.sendRedirect(req.getContextPath() +"/login");
            return;
        }
        String url = req.getRequestURL().toString();
        if (url.contains("delete")) {
            delete(req, resp);
        } else {
            findAll(req, resp);
            req.getRequestDispatcher("/view/user/cart.jsp").forward(req, resp);
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
            session.setAttribute("user", user);
            Cart cart = cartService.findCartByUserId(user.getUserId());
            req.setAttribute("cart", cart);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            cartItemsService.deleteCartItems(id);
            resp.sendRedirect(req.getContextPath() + "/cart");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }


}
