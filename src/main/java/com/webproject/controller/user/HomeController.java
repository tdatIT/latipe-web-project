package com.webproject.controller.user;

import com.webproject.model.Category;
import com.webproject.model.Product;
import com.webproject.service.ICategoryService;
import com.webproject.service.IProductService;
import com.webproject.service.impl.CategoryServiceImpl;
import com.webproject.service.impl.ProductServiceImpl;
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

@WebServlet(urlPatterns = {Router.HOME, ""})
public class HomeController extends HttpServlet {
    ICategoryService categoryService = new CategoryServiceImpl();
    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            List<Category> categories = categoryService.findAll();
            List<Product> flashSale = productService.find6FlashSale();
            List<Product> newProducts = productService.newProductList();
            List<Product> hotProducts = productService.findHotProduct();
            int userId = 0;
            if (session.getAttribute(SessionVar.USER_ID) != null) {
                userId = (Integer) session.getAttribute(SessionVar.USER_ID);
            }
            List<Product> productsForYou = productService.findProductForYou(userId);
            req.setAttribute("categories", categories);
            req.setAttribute("flashSale", flashSale);
            req.setAttribute("forYou", productsForYou);
            req.setAttribute("hotProducts", hotProducts);
            req.setAttribute("newProducts",newProducts);
            req.getRequestDispatcher(Router.HOME_PAGE).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher(Router.ERROR_404_PAGE).forward(req, resp);
        }
    }
}
