package com.webproject.controller.vendor;

import com.webproject.service.IProductService;
import com.webproject.service.impl.ProductServiceImpl;
import com.webproject.variable.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = Router.S_PRODUCT_D)
public class ProductDeleteController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            if (productService.disableProduct(productId)) {
                resp.sendRedirect(req.getContextPath() + Router.STORE_P);
            } else {
                req.setAttribute("message", false);
                resp.sendRedirect(req.getContextPath() + Router.STORE_P);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
