package com.webproject.controller.vendor;


import com.webproject.controller.uploads.UploadFile;
import com.webproject.model.Category;
import com.webproject.model.Product;
import com.webproject.model.ProductImg;
import com.webproject.service.ICategoryService;
import com.webproject.service.IProductImgService;
import com.webproject.service.IProductService;
import com.webproject.service.impl.CategoryServiceImpl;
import com.webproject.service.impl.ProductImgServiceImpl;
import com.webproject.service.impl.ProductServiceImpl;
import com.webproject.variable.Router;
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 4,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = Router.S_PRODUCT_U)
public class ProductUpdateController extends HttpServlet {

    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    IProductImgService productImgService = new ProductImgServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        try {
            if (req.getParameter("productId") != null) {
                int productId = Integer.parseInt(req.getParameter("productId"));
                HttpSession session = req.getSession();
                int storeId = (Integer) session.getAttribute(SessionVar.STORE_ID);
                Product product = productService.findById(productId);
                if (product != null && product.getStoreId() == storeId) {
                    req.setAttribute("product", product);
                    req.setAttribute("images", product.getProductImgsByProductId());
                    req.getRequestDispatcher("/" + Router.S_PRODUCT_INFO_PAGE).forward(req, resp);
                } else
                    resp.sendRedirect(req.getContextPath() + Router.STORE_D);
            } else {
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
            int product_id = Integer.parseInt(req.getParameter("productId"));
            //Create product obj and set properties
            Product product = getProductFromRequest(product_id, req);
            //If update product success, then insert new image
            if (req.getPart("images") != null
                    && productService.updateProduct(product)) {
                ProductImg img = new ProductImg();
                img.setLocation("upload");
                img.setFileName(UploadFile.uploadFile(req, "images"));
                img.setProductId(product_id);
                productImgService.insertProductImage(img);
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

    protected Product getProductFromRequest(int id, HttpServletRequest req) {
        Product product = productService.findById(id);
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
            product.setUpdateDate(new Date(new java.util.Date().getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
