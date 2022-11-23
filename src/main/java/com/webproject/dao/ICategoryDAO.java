package com.webproject.dao;

import com.webproject.model.Category;
import com.webproject.model.Delivery;

import java.util.HashMap;
import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll();


    Category findById(int id);

    Category findByName(String name);

    boolean insertCategory(Category category);

    boolean updateCategory(Category category);

    boolean disableCategory(int id);
    public HashMap<Integer, Object > paginate(String search, int page, int option);
}
