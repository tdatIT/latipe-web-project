package com.webproject.service;

import com.webproject.model.Category;

import java.util.HashMap;
import java.util.List;

public interface ICategoryService {
    List<Category> findAll();


    Category findById(int id);

    Category findByName(String name);

    boolean insertCategory(Category category);

    boolean updateCategory(Category category);

    boolean disableCategory(int id);

    public HashMap<Integer, Object> paginate(String search,int option, int page);
}
