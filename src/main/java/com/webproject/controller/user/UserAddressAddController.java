package com.webproject.controller.user;

import com.webproject.controller.uploads.UploadFile;
import com.webproject.model.Store;
import com.webproject.model.User;
import com.webproject.model.UserAddress;
import com.webproject.service.IUserAddressService;
import com.webproject.service.impl.UserAddressServiceImpl;
import com.webproject.variable.RoleConst;
import com.webproject.variable.Router;
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = {"/userAddress/create"})

public class UserAddressAddController extends HttpServlet {
   IUserAddressService userAddressService=new UserAddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(SessionVar.USER_ID) != null) {
                if (session.getAttribute(SessionVar.ADDRESS_ID) == null) {
                    req.getRequestDispatcher("/" + Router.USERADDRESS).forward(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + Router.USERADDRESS);
                }
            } else
                resp.sendRedirect(req.getContextPath() + Router.USERADDRESS);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + Router.ERROR404);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            if (session.getAttribute(SessionVar.USER_ID) != null) {
                int user_id = (Integer) session.getAttribute(SessionVar.USER_ID);

                UserAddress NewuserAddress=new UserAddress();
                NewuserAddress.setNumberPhone(req.getParameter("number_phone"));
                NewuserAddress.setZipcode(req.getParameter("zipcode"));
                NewuserAddress.setCity(req.getParameter("city"));
                NewuserAddress.setNameRecipient(req.getParameter("name_recipient"));
                NewuserAddress.setCountry(req.getParameter("country"));


                NewuserAddress.setUserId(user_id);
               userAddressService.insertUserAddress(NewuserAddress);

                resp.sendRedirect(req.getContextPath() + Router.LOGIN_PAGE);
                req.getRequestDispatcher(req.getContextPath() + Router.USERADDRESS).forward(req, resp);
            } else
                resp.sendRedirect(req.getContextPath() + Router.LOGIN);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + Router.ERROR404);
        }

    }
}
