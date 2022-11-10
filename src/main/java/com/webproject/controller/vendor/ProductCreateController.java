package com.webproject.controller.vendor;

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
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = {Router.S_PRODUCT_INFO})
public class ProductController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        try {
            if (req.getParameter("productId") == null) {
                req.getRequestDispatcher("/" + Router.S_PRODUCT_INFO_PAGE).forward(req, resp);
            } else {
                int productId = Integer.parseInt(req.getParameter("productId"));
                HttpSession session = req.getSession();
                int storeId = (Integer) session.getAttribute(SessionVar.STORE_ID);
                Product product = productService.findById(productId);
                if (product != null && product.getStoreId() == storeId) {
                    req.setAttribute("product", product);
                    req.getRequestDispatcher("/" + Router.S_PRODUCT_INFO_PAGE).forward(req, resp);
                } else
                    resp.sendRedirect("/" + Router.ERROR404);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            Product product = getProductFromRequest(req);
            product.setCreateDate(new Date(new java.util.Date().getTime()));
            product.setStoreId((Integer) session.getAttribute(SessionVar.STORE_ID));
            if (productService.insertProduct(product)) {
                resp.sendRedirect(req.getContextPath() + Router.STORE_P);
            } else {
                req.setAttribute("product", product);
                req.setAttribute("status", 0);
                req.getRequestDispatcher("/" + Router.S_PRODUCT_INFO_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/" + Router.ERROR404);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            Product product = getProductFromRequest(req);
            product.setCreateDate(new Date(new java.util.Date().getTime()));
            product.setProductId(Integer.parseInt(req.getParameter("productId")));
            product.setStoreId((Integer) session.getAttribute(SessionVar.STORE_ID));

            if (productService.updateProduct(product)) {
                resp.sendRedirect(req.getContextPath() + Router.STORE_P);
            } else {
                req.setAttribute("product", product);
                req.setAttribute("status", 1);
                req.getRequestDispatcher("/" + Router.S_PRODUCT_INFO_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/" + Router.ERROR404);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    protected Product getProductFromRequest(HttpServletRequest req) {
        Product product = new Product();
        try {
            boolean status = true;
            if (req.getParameter("status").equals("0"))
                status = false;
            product.setName(req.getParameter("name"));
            product.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
            product.setPrice(Float.parseFloat(req.getParameter("price")));
            product.setPromotionalPrice(Double.parseDouble(req.getParameter("promotionalPrice")));
            product.setActive(status);
            product.setDescription(req.getParameter("description"));
            product.setVideo(req.getParameter("video"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
