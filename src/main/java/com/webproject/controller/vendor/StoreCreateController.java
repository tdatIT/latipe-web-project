package com.webproject.controller.vendor;

import com.webproject.controller.uploads.UploadFile;
import com.webproject.model.Store;
import com.webproject.model.User;
import com.webproject.service.IStoreService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.StoreServiceImpl;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.variable.RoleConst;
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

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 4,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = {Router.STORE_CREATE})
public class StoreCreateController extends HttpServlet {
    IStoreService storeService = new StoreServiceImpl();
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute(SessionVar.USER_ID) != null) {
                if (session.getAttribute(SessionVar.STORE_ID) == null) {
                    req.getRequestDispatcher("/" + Router.S_CREATE_PAGE).forward(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + Router.STORE_D);
                }
            } else
                resp.sendRedirect(req.getContextPath() + Router.LOGIN);
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
                Store newStore = new Store();
                newStore.setName(req.getParameter("name"));
                newStore.setBio(req.getParameter("bio"));
                newStore.setAvatar(UploadFile.uploadFile(req, "avatar"));
                newStore.setCover(UploadFile.uploadFile(req, "cover"));

                newStore.setOwnId(user_id);
                User us = userService.findById(user_id);
                us.setRoleId(RoleConst.VENDOR);
                userService.updateUser(us);
                storeService.createStore(newStore);
                resp.sendRedirect(req.getContextPath() + Router.STORE_LOGIN);
            } else
                resp.sendRedirect(req.getContextPath() + Router.LOGIN);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + Router.ERROR404);
        }
    }
}
