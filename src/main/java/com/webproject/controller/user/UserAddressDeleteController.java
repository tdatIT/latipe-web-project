package com.webproject.controller.user;

import com.webproject.service.IUserAddressService;
import com.webproject.service.impl.UserAddressServiceImpl;
import com.webproject.variable.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAddressDeleteController extends HttpServlet {
    IUserAddressService userAddressService=new UserAddressServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            Integer AddressId = Integer.parseInt(req.getParameter("address_id"));
            if (userAddressService.deleteUserAddress(AddressId)) {
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
