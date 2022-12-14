package com.webproject.controller.admin;


import com.webproject.model.StoreLevel;
import com.webproject.service.IStoreLevelService;
import com.webproject.service.impl.StoreLevelServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/admin/storeLevel", "/admin/storeLevel/create", "/admin/storeLevel/update",
        "/admin/storeLevel/edit", "/admin/storeLevel/delete"})
public class StoreLevelController extends HttpServlet {
    IStoreLevelService com = new StoreLevelServiceImpl();

    public StoreLevelController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("delete")) {
            doPost(req, resp);
            return;
        }
        findAll(req, resp);
//        req.setAttribute("tag", "cate");
        try{
            req.getRequestDispatcher("/view/admin/storeLevel.jsp").forward(req, resp);

        }
        catch (Exception e){

        }
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
        resp.sendRedirect(req.getContextPath() + "/admin/storeLevel");
    }

    protected void insert(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            StoreLevel StoreLevel = new StoreLevel();
            BeanUtils.populate(StoreLevel, req.getParameterMap());
            com.insertStoreLevel(StoreLevel);
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
            List<StoreLevel> storeLevels = (List<StoreLevel>) entry.getValue();

            int endPage = size / 10;
            if (size % 3 != 10 && size > 10) {
                endPage++;
            }endPage = endPage > 0 ? endPage - 1 : endPage;
            req.setAttribute("endPage", endPage);
            req.setAttribute("storeLevels", storeLevels);
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
            String storeLevelId = req.getParameter("storeLevelId");
            StoreLevel storeLevel = com.findById(Integer.parseInt(storeLevelId));

            req.setAttribute("storeLevel", storeLevel);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {

            String storeLevelId = req.getParameter("storeLevelId");
            com.disableStoreLevel(Integer.parseInt(storeLevelId));
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
            int storeLevelId = Integer.parseInt(req.getParameter("storeLevelId"));
            StoreLevel a = com.findById(storeLevelId);
            StoreLevel storeLevel = new StoreLevel();
            BeanUtils.populate(storeLevel, req.getParameterMap());
            com.updateStoreLevel(storeLevel);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());

        }

    }
}
