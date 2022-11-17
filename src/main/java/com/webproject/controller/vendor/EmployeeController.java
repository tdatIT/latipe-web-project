package com.webproject.controller.vendor;

import com.webproject.model.User;
import com.webproject.service.IUserService;
import com.webproject.service.impl.UserServiceImpl;
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
import java.util.List;

@WebServlet(urlPatterns = {"/store-admin/employee", "/store-admin/emp-add", "/store-admin/emp-remove"})
public class EmployeeController extends HttpServlet {
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            String action = req.getServletPath();
            if (action.equals("/store-admin/employee")) {
                int storeId = (Integer) session.getAttribute(SessionVar.STORE_ID);
                List<User> users = userService.findByStore(storeId);
                req.setAttribute("users", users);
                req.getRequestDispatcher("/view/vendor/emp.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + Router.ERROR404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            String action = req.getServletPath();
            int storeId = (Integer) session.getAttribute(SessionVar.STORE_ID);
            if (action.equals("/store-admin/emp-add")) {
                String email = req.getParameter("email");
                User user = userService.getUserByEmail(email);
                if (user.getRoleId() != RoleConst.VENDOR) {
                    user.setRoleId(RoleConst.COLLAB);
                    user.setStoreEmpId(storeId);
                    userService.updateUser(user);
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                    resp.getWriter();
                }
            } else {
                int userId = Integer.parseInt(req.getParameter("userId"));
                User user = userService.findById(userId);
                if (user.getRoleId() != RoleConst.VENDOR) {
                    user.setRoleId(RoleConst.USER);
                    user.setStoreEmpId(null);
                    userService.updateUser(user);
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                    resp.getWriter();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_FOUND);
            resp.getWriter();
        }
    }
}
