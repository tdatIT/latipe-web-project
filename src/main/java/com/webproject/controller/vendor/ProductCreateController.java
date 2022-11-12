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
@WebServlet(urlPatterns = {Router.S_PRODUCT_C})
public class ProductCreateController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    IProductImgService productImgService = new ProductImgServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        try {
            req.getRequestDispatcher("/" + Router.S_PRODUCT_INFO_PAGE).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/" + Router.ERROR404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            //Create product object from form http request
            Product product = getProductFromRequest(req);
            product.setCreateDate(new Date(new java.util.Date().getTime()));
            product.setStoreId((Integer) session.getAttribute(SessionVar.STORE_ID));
            //Set img into product and update entity into database
            int id_new_product = productService.insertProduct(product);
            if (id_new_product != 0) {
                //Insert image into product
                ProductImg img = new ProductImg();
                img.setProductId(id_new_product);
                img.setLocation("upload");
                img.setFileName(UploadFile.uploadFile(req, "images"));
                productImgService.insertProductImage(img);
                resp.sendRedirect(req.getContextPath() + Router.STORE_P);
            } else {
                //Update fail
                req.setAttribute("product", product);
                req.setAttribute("status", 0);
                req.getRequestDispatcher("/" + Router.S_PRODUCT_INFO_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/" + Router.ERROR404);
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
            product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
            product.setPrice(Float.parseFloat(req.getParameter("price")));
            product.setPromotionalPrice(Double.parseDouble(req.getParameter("promotionalPrice")));
            product.setActive(status);
            product.setDescription(req.getParameter("description"));
            product.setVideo(req.getParameter("video"));
            //image of product
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
