package com.webproject.controller.admin;


import com.webproject.controller.uploads.UploadFile;
import com.webproject.model.Category;
import com.webproject.service.ICategoryService;
import com.webproject.service.impl.CategoryServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 4,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = {"/admin/category", "/admin/category/create", "/admin/category/update",
        "/admin/category/edit", "/admin/category/delete"})
public class CategoryController extends HttpServlet {
    ICategoryService com = new CategoryServiceImpl();

    public CategoryController() {
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
        req.getRequestDispatcher("/view/admin/category.jsp").forward(req, resp);
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
        resp.sendRedirect(req.getContextPath() + "/admin/category");
    }

    protected void insert(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            Category Category = new Category();
            BeanUtils.populate(Category, req.getParameterMap());

            Part part = req.getPart("image");
            String realPath = req.getServletContext().getRealPath("/upload");
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }
            part.write(realPath + "/" + filename);
            Category.setImage(filename);

            com.insertCategory(Category);
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
            List<Category> categorys = (List<Category>) entry.getValue();

            int endPage = size / 10;
            if (size % 10 != 0 && size > 10) {
                endPage++;
            }
            endPage = endPage > 0 ? endPage - 1 : endPage;
            req.setAttribute("endPage", endPage);
            req.setAttribute("categorys", categorys);
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
            String categoryId = req.getParameter("categoryId");
            Category category = com.findById(Integer.parseInt(categoryId));

            req.setAttribute("category", category);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String categoryId = req.getParameter("categoryId");
            com.disableCategory(Integer.parseInt(categoryId));
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
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            Category old = com.findById(categoryId);
            Category category = new Category();
            BeanUtils.populate(category, req.getParameterMap());

            if (req.getPart("image").getSize() == 0) {
                category.setImage(old.getImage());
            } else {
                category.setImage(UploadFile.uploadFile(req, "image"));
            }
            com.updateCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());

        }

    }
}
