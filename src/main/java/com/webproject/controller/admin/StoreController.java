package com.webproject.controller.admin;


import com.webproject.model.Store;
import com.webproject.model.User;
import com.webproject.service.IStoreService;
import com.webproject.service.IUserService;
import com.webproject.service.impl.StoreServiceImpl;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.variable.SessionVar;

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

@WebServlet(urlPatterns = {"/admin/store", "/admin/store/create", "/admin/store/update",
        "/admin/store/edit", "/admin/store/delete"})
public class StoreController extends HttpServlet {
    IStoreService com = new StoreServiceImpl();

    public StoreController() {
        super();
    }

    IUserService userService = new UserServiceImpl();

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
        if (url.contains("active")) {
            active(req, resp);
            return;
        } else if (url.contains("delete")) {
            doPost(req, resp);
            return;
        }
        findAll(req, resp);
        req.getRequestDispatcher("/view/admin/store.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("active")) {
            active(req, resp);
        } else if (url.contains("delete")) {
            delete(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/store");
    }

    protected void active(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String storeId = req.getParameter("storeId");
            com.setStatus(Integer.parseInt(storeId), true);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String storeId = req.getParameter("storeId");
            com.setStatus(Integer.parseInt(storeId), false);
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
            HashMap<Integer, Object> list = com.paginate(search, page, option);

            Map.Entry<Integer, Object> entry = list.entrySet().iterator().next();
            int size = entry.getKey();
            List<Store> stores = (List<Store>) entry.getValue();

            int endPage = size / 10;
            if (size % 3 != 10 && size > 10) {
                endPage++;
            }
            endPage = endPage > 0 ? endPage - 1 : endPage;
            req.setAttribute("endPage", endPage);
            req.setAttribute("stores", stores);
            req.setAttribute("tag", page);
            req.setAttribute("search", search);
            req.setAttribute("option", option);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }


}
