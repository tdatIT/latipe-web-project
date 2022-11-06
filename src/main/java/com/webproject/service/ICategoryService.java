package com.webproject.service;

import com.webproject.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    List<Category> findByParentId(int id);

    Category findById(int id);

    Category findByName(String name);

    boolean insertCategory(Category category);

    boolean updateCategory(Category category);

    boolean disableCategory(int id);
}
