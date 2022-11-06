package com.webproject.service.impl;

import com.webproject.dao.ICategoryDAO;
import com.webproject.dao.impl.CategoryDAOImpl;
import com.webproject.model.Category;
import com.webproject.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public List<Category> findByParentId(int id) {
        return categoryDAO.findByParentId(id);
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryDAO.findByName(name);
    }

    @Override
    public boolean insertCategory(Category category) {
        return categoryDAO.insertCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryDAO.updateCategory(category);
    }

    @Override
    public boolean disableCategory(int id) {
        return categoryDAO.disableCategory(id);
    }
}
