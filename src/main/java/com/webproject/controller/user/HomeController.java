package com.webproject.controller.user;

import com.webproject.model.Category;
import com.webproject.service.ICategoryService;
import com.webproject.service.impl.CategoryServiceImpl;
import com.webproject.variable.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {Router.HOME, ""})
public class HomeController extends HttpServlet {
    ICategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            List<Category> categories = service.findAll();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher(Router.HOME_PAGE).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher(Router.ERROR_404_PAGE).forward(req, resp);
        }
    }
}
