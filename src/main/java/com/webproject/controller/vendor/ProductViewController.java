package com.webproject.controller.vendor;

import com.webproject.model.Product;
import com.webproject.service.IProductService;
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

@WebServlet(urlPatterns = {Router.STORE_P})
public class ProductViewController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            int store_id = (Integer) session.getAttribute(SessionVar.STORE_ID);
            List<Product> products = productService.findProductByStoreId(store_id);
            req.setAttribute("products", products);
            req.getRequestDispatcher("/" + Router.S_PRODUCT_PAGE).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + Router.ERROR404);
        }
    }

}
