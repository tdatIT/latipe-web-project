package com.webproject.controller.user;


import com.webproject.model.Product;
import com.webproject.model.UserFollowStore;
import com.webproject.service.IProductService;
import com.webproject.service.IUserFollowStoreService;
import com.webproject.service.impl.ProductServiceImpl;
import com.webproject.service.impl.UserFollowStoreServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/user/follow", "/user/unfollow"})
public class FollowStoreController extends HttpServlet {
    IUserFollowStoreService com = new UserFollowStoreServiceImpl();

    // muon sua chu nhanh -> boi den xong cltr +r
    // option cc là nó sẻ match đúng chữ phân biệt viết hoa vs viết thường
    // vd: AAAAA aaaaa
    // t chon vao Cc -> no chi match dung chu aaaaa
    // nhiêu đó đủ copy paste nhanh r
    // t lam mau cho cai product
    public FollowStoreController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("follow")) {
            follow(req, resp);
            return;
        }else if (url.contains("unfollow")) {
            unfollow(req, resp);
            return;
        }
        resp.sendRedirect("/"); // i nưa tu sua lai cho nay
//        req.getRequestDispatcher("/view/admin/product.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        String url = req.getRequestURL().toString();
//        if (url.contains("active")) {
//            active(req, resp);
//        }else if (url.contains("delete")) {
//            delete(req, resp);
//        }
//        resp.sendRedirect(req.getContextPath() + "/admin/product");
    }

    protected void follow(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(req.getParameter("userId"));
            int storeId =Integer.parseInt( req.getParameter("storeId"));
            UserFollowStore a = com.checkExists(userId, storeId);
            if (a != null){
                a.setDeleted(false);
                com.updateUserFollowStore(a);
            }else{
                a = new UserFollowStore();
                a.setStoreId(storeId);
                a.setUserId(userId);
                com.insertUserFollowStore(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void unfollow(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            UserFollowStore a = com.findById(id);
            a.setDeleted(true);
            com.updateUserFollowStore(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
