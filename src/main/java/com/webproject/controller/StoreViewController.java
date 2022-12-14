package com.webproject.controller;

import com.webproject.model.Product;
import com.webproject.model.Store;
import com.webproject.service.IProductService;
import com.webproject.service.IStoreService;
import com.webproject.service.impl.ProductServiceImpl;
import com.webproject.service.impl.StoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/store-view"})
public class StoreViewController extends HttpServlet {
    IStoreService storeService = new StoreServiceImpl();
    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            if (req.getParameter("storeId") != null) {
                int storeId = Integer.parseInt(req.getParameter("storeId"));
                Store store = storeService.findById(storeId);
                List<Product> products = productService.findProductByStoreId(storeId);
                req.setAttribute("store", store);
                req.setAttribute("products", products);
                req.getRequestDispatcher("/view/user/StoreProfile.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/404");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
