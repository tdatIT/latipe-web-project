package com.webproject.controller.admin;


import com.webproject.model.User;
import com.webproject.model.UserLevel;
import com.webproject.service.IUserLevelService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.UserLevelServiceImpl;
import com.webproject.service.impl.UserServiceImpl;
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

@WebServlet(urlPatterns = {"/admin/userLevel", "/admin/userLevel/create", "/admin/userLevel/update",
        "/admin/userLevel/edit", "/admin/userLevel/delete"})
public class UserLevelController extends HttpServlet {
    IUserLevelService com = new UserLevelServiceImpl();
    IUserService userService = new UserServiceImpl();

    public UserLevelController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute(SessionVar.USER_ID) == null) {
            resp.sendRedirect(req.getContextPath() +"/login");
            return;
        }
        if((Integer) session.getAttribute(SessionVar.ROLE_ID) != 1) {
            resp.sendRedirect(req.getContextPath() +"/login");
            return;
        }
        User user = userService.findById((Integer) session.getAttribute(SessionVar.USER_ID));
        req.setAttribute("user", user);
        String url = req.getRequestURL().toString();
        if (url.contains("delete")) {
            doPost(req, resp);
            return;
        }
        findAll(req, resp);
        req.getRequestDispatcher("/view/admin/userLevel.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("create")) {
            insert(req, resp);
        } else if (url.contains("edit")) {
            update(req, resp);
        } else if (url.contains("delete")) {
            delete(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/userLevel");
    }

    protected void insert(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            UserLevel UserLevel = new UserLevel();
            BeanUtils.populate(UserLevel, req.getParameterMap());
            com.insertUserLevel(UserLevel);
            req.setAttribute("message", "Đã thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }

    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int option = req.getParameter("option") != null ? Integer.parseInt(req.getParameter("option")) : 0;
            String search = req.getParameter("search") != null ? req.getParameter("search") : "";
            int page = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 0;
            HashMap<Integer, Object> list = com.paginate(search, page, option);

            Map.Entry<Integer, Object> entry = list.entrySet().iterator().next();
            int size = entry.getKey();
            List<UserLevel> userLevels = (List<UserLevel>) entry.getValue();

            int endPage = size / 10;
            if (size % 3 != 10 && size > 10) {
                endPage++;
            }
            endPage = endPage > 0 ? endPage - 1 : endPage;
            req.setAttribute("endPage", endPage);
            req.setAttribute("userLevels", userLevels);
            req.setAttribute("tag", page);
            req.setAttribute("search", search);
            req.setAttribute("option", option);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String userLevelId = req.getParameter("userLevelId");
            UserLevel userLevel = com.findById(Integer.parseInt(userLevelId));

            req.setAttribute("userLevel", userLevel);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {

            String userLevelId = req.getParameter("userLevelId");
            com.disableUserLevel(Integer.parseInt(userLevelId));
            req.setAttribute("message", "Đã xóa thành công");

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute("error", "Error: " + e.getMessage());

        }

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            int userLevelId = Integer.parseInt(req.getParameter("userLevelId"));
            UserLevel a = com.findById(userLevelId);
            UserLevel userLevel = new UserLevel();
            BeanUtils.populate(userLevel, req.getParameterMap());
            com.updateUserLevel(userLevel);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());

        }

    }
}
