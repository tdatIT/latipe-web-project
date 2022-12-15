package com.webproject.controller.user;

import com.webproject.model.*;
import com.webproject.service.ICartService;
import com.webproject.service.IOrderService;
import com.webproject.service.IUserAddressService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.CartServiceImpl;
import com.webproject.service.impl.OrderServiceImpl;
import com.webproject.service.impl.UserAddressServiceImpl;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {
    private static float discountFromGD = 0.08F;
    private static Boolean payment_on_receipt = false;

    private ICartService cartService = new CartServiceImpl();
    private IUserService userService = new UserServiceImpl();
    private IUserAddressService userAddressService = new UserAddressServiceImpl();

    private IOrderService orderService = new OrderServiceImpl();

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
                    req.getRequestDispatcher("/view/user/checkout.jsp").forward(req, resp);
                }
            } else
                resp.sendRedirect(req.getContextPath() + "/login");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            if (session.getAttribute(SessionVar.USER_ID) != null) {
                int userId = (Integer) session.getAttribute(SessionVar.USER_ID);
                Cart cart = cartService.findCartByUserId(userId);
                if (cart.getCartItemsByCartId().size() == 0)
                    resp.sendRedirect(req.getContextPath() + "/cart");
                else {
                    Orders orders = new Orders();
                    int addressId = Integer.parseInt(req.getParameter("addressId"));
                    double total = Double.parseDouble(req.getParameter("total"));
                    UserAddress ad = userAddressService.findById(addressId);
                    //set data for order
                    orders.setStatus(1);
                    orders.setAddress(ad.getZipcode());
                    orders.setPaidBefore(payment_on_receipt);
                    orders.setAmountFromUser(total);
                    orders.setDeliveryId(1);
                    orders.setAmountToGd(total * discountFromGD);
                    orders.setAmountToStore(total - orders.getAmountToGd());
                    orders.setUserId(userId);
                    orders.setPhone(ad.getNumberPhone());
                    orders.setStoreId(cart.getCartItemsByCartId().iterator().next()
                            .getProductByProductId()
                            .getStoreId());
                    orders.setCreateDate(new Date(new java.util.Date().getTime()));

                    List<OrderItems> items = new ArrayList<>();
                    for (CartItems cartItems : cart.getCartItemsByCartId()) {
                        OrderItems o = new OrderItems();
                        o.setQuantity(cartItems.getQuantity());
                        o.setProductId(cartItems.getCartId());
                        o.setOrder(orders);
                        items.add(o);

                    }
                    orders.setItem(items);
                    orderService.insertOrder(orders);
                    cartService.deletedItems(cart);
                }
            } else
                resp.sendRedirect(req.getContextPath() + "/login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
