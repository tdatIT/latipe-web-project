package com.webproject.controller.user;

import com.webproject.model.UserAddress;
import com.webproject.service.IUserAddressService;
import com.webproject.service.impl.UserAddressServiceImpl;
import com.webproject.variable.SessionVar;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/userAddress", "/userAddress/create", "/userAddress/edit"})
public class UserAddressController extends HttpServlet {

    IUserAddressService userAddressService = new UserAddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURL().toString();

        if (url.contains("edit")) {
            doPost(req, resp);
        } else if (url.contains("delete")) {
            doPost(req, resp);
        }
//        req.getRequestDispatcher("/view/user/user.jsp").forward(req, resp);
//        resp.sendRedirect(req.getContextPath() + "/user");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURL().toString();
        if (url.contains("edit")) {
            edit(req, resp);
        } else if (url.contains("delete")) {
            delete(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/user");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String address_id = req.getParameter("address_id");
            userAddressService.setStatus(Integer.parseInt(address_id), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int option = req.getParameter("option") != null ? Integer.parseInt(req.getParameter("option")) : 0;
            String search = req.getParameter("search") != null ? req.getParameter("search") : "";
            int page = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 0;
            HashMap<Integer, Object> list = userAddressService.paginate(search, option, page);

            // lay toan bo danh sach user
            Map.Entry<Integer, Object> entry = list.entrySet().iterator().next();
            // lay ra tong so trang
            int size = entry.getKey();
            List<UserAddress> users = (List<UserAddress>) entry.getValue();

            int endPage = size / 10;
            if (size % 3 != 10 && size > 10) {
                endPage++;
            }
            endPage = endPage > 0 ? endPage - 1 : endPage;
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

    protected void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            int user_id = (Integer) session.getAttribute(SessionVar.USER_ID);
            UserAddress com = new UserAddress();
            com.setUserId(user_id);
            BeanUtils.populate(com, req.getParameterMap());

            userAddressService.updateUserAddress(com);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

