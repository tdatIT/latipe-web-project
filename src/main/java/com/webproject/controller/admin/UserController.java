package com.webproject.controller.admin;


import com.webproject.model.User;
import com.webproject.service.IUserService;
import com.webproject.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/admin/user", "/admin/user/create", "/admin/user/update",
        "/admin/user/edit", "/admin/user/delete"})
public class UserController extends HttpServlet {
    IUserService com = new UserServiceImpl();

    public UserController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("active")) {
            active(req, resp);
        } else if (url.contains("delete")) {
            doPost(req, resp);
            return;
        }
        findAll(req, resp);
        req.getRequestDispatcher("/view/admin/user.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("active")) {
            active(req, resp);
        } else if (url.contains("delete")) {
            delete(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/user");
    }
    protected void findAll(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int option = req.getParameter("option") != null ? Integer.parseInt(req.getParameter("option")) : 0;
            String search = req.getParameter("search") != null ? req.getParameter("search") : "";
            int page = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 0;
            HashMap<Integer, Object> list = com.paginate(search, option, page);

            // lay toan bo danh sach user
            Map.Entry<Integer, Object> entry = list.entrySet().iterator().next();
            // lay ra tong so trang
            int size = entry.getKey();
            List<User> users = (List<User>) entry.getValue();

            int endPage = size / 10;
            if (size % 3 != 10 && size > 10) {
                endPage++;
            }endPage = endPage > 0 ? endPage - 1 : endPage;
            req.setAttribute("endPage", endPage);
            req.setAttribute("users", users);
            req.setAttribute("tag", page);
            req.setAttribute("search", search);
            req.setAttribute("option", option);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String userId = req.getParameter("userId");
            com.setStatus(Integer.parseInt(userId), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void active(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String userId = req.getParameter("userId");
            com.setStatus(Integer.parseInt(userId), false);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
