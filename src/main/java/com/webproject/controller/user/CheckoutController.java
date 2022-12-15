package com.webproject.controller.user;

import com.webproject.model.Cart;
import com.webproject.model.User;
import com.webproject.service.ICartService;
import com.webproject.service.IUserService;
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

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {
    private static float discountFromGD = 0.08F;
    private static Boolean payment_on_receipt = false;

    private ICartService cartService = new CartServiceImpl();
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            if (session.getAttribute(SessionVar.USER_ID) != null) {
                int userId = (Integer) session.getAttribute(SessionVar.USER_ID);
                Cart cart = cartService.findCartByUserId(userId);
                if (cart.getCartItemsByCartId().size() == 0)
                    resp.sendRedirect(req.getContextPath() + "/cart");
                else {
                    User user = userService.findById(userId);
                    req.setAttribute("user", user);
                    req.setAttribute("cart", cart);
                    req.getRequestDispatcher("/view/user/checkout.jsp").forward(req,resp);
                }
            } else
                resp.sendRedirect(req.getContextPath() + "/login");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
