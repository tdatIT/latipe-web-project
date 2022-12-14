package com.webproject.service.impl;

import com.webproject.dao.ICartDAO;
import com.webproject.dao.impl.CartDAO;
import com.webproject.dao.impl.CategoryDAOImpl;
import com.webproject.model.Cart;
import com.webproject.model.Category;
import com.webproject.service.ICartService;

import java.util.List;

public class CartServiceImpl implements ICartService     {
    ICartDAO cartDAO = new CartDAO();

    @Override
    public Cart findById(int id) {
        return cartDAO.findById(id);
    }
}
