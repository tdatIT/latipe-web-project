package com.webproject.controller.user;

import com.webproject.model.User;
import com.webproject.service.IUserAddressService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.UserAddressServiceImpl;
import com.webproject.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user", "/user/edit", "/user/resetpassword"})
public class UserController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
//    IUserAddressService userAddressService = new UserAddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURL().toString();
        if (url.contains("active")) {
            active(req, resp);
        } else if (url.contains("delete")) {
            doPost(req, resp);
            return;
        }
        findAll(req, resp);
        req.getRequestDispatcher("/view/user/user.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURL().toString();
        if (url.contains("active")) {
            active(req, resp);
        } else if (url.contains("delete")) {
            delete(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/user/userAddress");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
//            String address_id = req.getParameter("address_id");
//            userAddressService.setStatus(Integer.parseInt(address_id), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            // lay ra thong tin user
            User user = userService.findById(2);
            req.setAttribute("user", user);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void active(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String address_id = req.getParameter("address_id");
//            userAddressService.setStatus(Integer.parseInt(address_id), false);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

