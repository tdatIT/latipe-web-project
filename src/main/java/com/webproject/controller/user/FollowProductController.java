package com.webproject.controller.user;


import com.webproject.model.UserFollowProduct;
import com.webproject.service.IUserFollowProductService;
import com.webproject.service.impl.UserFollowProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user/followProduct", "/user/unfollowProduct"})
public class FollowProductController extends HttpServlet {
    IUserFollowProductService com = new UserFollowProductServiceImpl();

    // muon sua chu nhanh -> boi den xong cltr +r
    // option cc là nó sẻ match đúng chữ phân biệt viết hoa vs viết thường
    // vd: AAAAA aaaaa
    // t chon vao Cc -> no chi match dung chu aaaaa
    // nhiêu đó đủ copy paste nhanh r
    // t lam mau cho cai product
    // muon format code thi cltr + a + l
    public FollowProductController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("follow")) {
            follow(req, resp);
            return;
        } else if (url.contains("unfollow")) {
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
            int productId = Integer.parseInt(req.getParameter("productId"));
            UserFollowProduct a = com.checkExists(userId, productId);
            if (a != null) {
                a.setDeleted(false);
                com.updateUserFollowProduct(a);
            } else {
                a = new UserFollowProduct();
                a.setProductId(productId);
                a.setUserId(userId);
                com.insertUserFollowProduct(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void unfollow(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            UserFollowProduct a = com.findById(id);
            a.setDeleted(true);
            com.updateUserFollowProduct(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
