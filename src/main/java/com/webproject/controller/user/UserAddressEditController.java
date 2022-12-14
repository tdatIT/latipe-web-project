package com.webproject.controller.user;

import com.webproject.model.Store;
import com.webproject.model.User;
import com.webproject.model.UserAddress;
import com.webproject.service.IStoreService;
import com.webproject.service.IUserAddressService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.StoreServiceImpl;
import com.webproject.service.impl.UserAddressServiceImpl;
import com.webproject.service.impl.UserServiceImpl;
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

@WebServlet(urlPatterns = {"/user/userAddress/edit"})
public class UserAddressEditController extends HttpServlet {

    IUserAddressService userAddressService=new UserAddressServiceImpl();
    IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            int userId = Integer.parseInt(req.getParameter("user_id"));
            HttpSession session = req.getSession();

            if (session.getAttribute(SessionVar.USERADDRESS_OBJ) != null) {
                UserAddress userAddress = (UserAddress) session.getAttribute(SessionVar.ADDRESS_ID);
                User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
                req.setAttribute("userAddress", userAddress);
                req.setAttribute("user", user);
                req.setAttribute("update", true);
                req.getRequestDispatcher("/" + Router.S_INFO_PAGE).forward(req, resp);
            } else
                resp.sendRedirect(req.getContextPath() + Router.STORE_LOGIN);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(SessionVar.STORE_OBJ) != null) {
                UserAddress userAddress = (UserAddress) session.getAttribute(SessionVar.ADDRESS_ID);
                User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
               userAddress.setCity( req.getParameter("city"));
               userAddress.setCountry(req.getParameter("country"));
               userAddress.setZipcode(req.getParameter("zipcode"));
               userAddress.setNameRecipient(req.getParameter("name_recipient"));


                userAddress.setNumberPhone(req.getParameter("number_phone"));
                //update
                userService.updateUser(user);
                userAddressService.updateUserAddress(userAddress);


                resp.sendRedirect(req.getContextPath() + Router.STORE_INFO);
            } else
                resp.sendRedirect(req.getContextPath() + Router.STORE_LOGIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
