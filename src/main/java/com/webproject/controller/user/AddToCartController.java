package com.webproject.controller.user;

import com.webproject.model.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/product", "/product/addToCart",})
public class AddToCartController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    ICartItemsService cartItemsService = new CartItemsServiceImpl();
    IProductService productService = new ProductServiceImpl();
    ICategoryService cateService = new CategoryServiceImpl();
    ICartService cartService = new CartServiceImpl();
//    IUserAddressService userAddressService = new UserAddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String url = req.getRequestURL().toString();
        int prodID = req.getParameter("id") != null ? Integer.parseInt(req.getParameter("id")) : -1;
        try {
            if (prodID == -1) {
                // show ra het san pham
                int cate = req.getParameter("cate") != null ? Integer.parseInt(req.getParameter("cate")) : -1;
                int maxPrice = req.getParameter("maxPrice") != null ? Integer.parseInt(req.getParameter("maxPrice")) : -1;
                int minPrice = req.getParameter("minPrice") != null ? Integer.parseInt(req.getParameter("minPrice")) : -1;
                int statusPrice = req.getParameter("status") != null ? Integer.parseInt(req.getParameter("status")) : -1;
                int page = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 0;
                String search = req.getParameter("search") != null ? req.getParameter("search") : "";

                List<Category> cates = cateService.findAll();
                List<Product> newProd = productService.newProductList();
                List<Product> saleProd = productService.find6FlashSale();

                HashMap<Integer, Object> list = productService.paginateWeb(search, page, cate, minPrice, maxPrice, statusPrice);
                Map.Entry<Integer, Object> entry = list.entrySet().iterator().next();
                int size = entry.getKey();
                List<Product> prods = (List<Product>) entry.getValue();
                int endPage = size / 12;
                if (size % 12 != 0 && size > 12) {
                    endPage++;
                }
                endPage = endPage > 0 ? endPage - 1 : endPage;
                req.setAttribute("size", size);
                req.setAttribute("endPage", endPage);
                req.setAttribute("tag", page);
                req.setAttribute("search", search);
                req.setAttribute("cates", cates);
                req.setAttribute("newProd", newProd);
                req.setAttribute("saleProd", saleProd);
                req.setAttribute("prods", prods);
                req.getRequestDispatcher("/view/user/products.jsp").forward(req, resp);
            } else if (url.contains("addToCart")) {
                addToCart(req, resp);
            } else {
                // hieern thi chi tiet 1 san pham
                Product prod = productService.findById(prodID);
                List<Product> products = productService.find6FlashSale();
                req.setAttribute("products", products);
                req.setAttribute("prod", prod);
                req.getRequestDispatcher("/view/user/ShoppingDetail.jsp").forward(req, resp);
            }
            //findAll(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURL().toString();
        if (url.contains("addToCart")) {
            addToCart(req, resp);
        } else if (url.contains("delete")) {
            delete(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/cart");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
//            String address_id = req.getParameter("address_id");
//            userAddressService.setStatus(Integer.parseInt(address_id), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            // lay ra thong tin user
            if (session.getAttribute(SessionVar.USER_ID) == null) {
                resp.sendRedirect("/login");
                return;
            }
            User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
            session.setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void addToCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(SessionVar.USER_ID) == null) {
                resp.sendRedirect("/login");
                return;
            }
            User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
            Cart cart = user.getCartsByUserId().stream().map(x -> (Cart) x).collect(Collectors.toList()).get(0);
            CartItems cartItems = new CartItems();
            int prodID = Integer.parseInt(req.getParameter("prodID"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            Cart cartData = cartService.findById(cart.getCartId());
            List<CartItems> listItem = cartData
                    .getCartItemsByCartId().stream()
                    .filter(x -> ((CartItems) x).getProductId() == prodID)
                    .collect(Collectors.toList());
            if (listItem.size() > 0) {
                listItem.get(0).setQuantity(listItem.get(0).getQuantity() + quantity);
                cartItemsService.updateCartItems(listItem.get(0));
            } else {
                cartItems.setCartId(cart.getCartId());
                cartItems.setProductId(prodID);
                cartItems.setQuantity(quantity);
                cartItemsService.insertCartItems(cartItems);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

