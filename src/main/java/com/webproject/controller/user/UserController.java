package com.webproject.controller.user;

import com.webproject.controller.uploads.UploadFile;
import com.webproject.model.User;
import com.webproject.service.IUserService;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.variable.SessionVar;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 4,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = {"/user", "/user/edit", "/user/changePass"})
public class UserController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
//    IUserAddressService userAddressService = new UserAddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String url = req.getRequestURL().toString();
        if (url.contains("delete")) {
            doPost(req, resp);
            return;
        }
        findAll(req, resp);
        try {
            req.getRequestDispatcher("/view/user/user.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String url = req.getRequestURL().toString();
        if (url.contains("edit")) {
            update(req, resp);
        } else if (url.contains("delete")) {
            delete(req, resp);
        } else if ((url.contains("changePass"))) {
            changePass(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/user");

    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
//
            String useId = req.getParameter("useId");
            userService.disableUser(Integer.parseInt(useId));
            req.setAttribute("message", "Đã xóa thành công");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void changePass(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            String password = req.getParameter("password");

            // lay ra thong tin user
            User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String passHash = DatatypeConverter
                    .printHexBinary(digest).toUpperCase();
            user.setHashedPassword(passHash);
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void findAll(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            // lay ra thong tin user
            User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
            session.setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void active(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String address_id = req.getParameter("userId");
//            userAddressService.setStatus(Integer.parseInt(address_id), false);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            int userId = (Integer) session.getAttribute(SessionVar.USER_ID);

            User old = userService.findById(userId);
            User user = new User();
            user.setUserId(userId);
            BeanUtils.populate(user, req.getParameterMap());
            user.setRoleId(old.getRoleId());
            user.setHashedPassword(old.getHashedPassword());
            user.setPoint(old.getPoint());
            user.seteWallet(old.geteWallet());
            user.setDeleted(old.getDeleted());
            user.setCreateDate(old.getUpdateDate());
            user.setCreateDate(old.getCreateDate());
            user.setUserLevelId(old.getUserLevelId());
            if (req.getPart("avatar").getSize() == 0) {
                user.setAvatar(old.getAvatar());

            } else {
                user.setAvatar(UploadFile.uploadFile(req, "avatar"));

            }
            userService.updateUser(user);
            req.setAttribute("message", "Đã thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());

        }

    }
}

