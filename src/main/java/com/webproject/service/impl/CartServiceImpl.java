package com.webproject.service.impl;

import com.webproject.dao.ICartDAO;
import com.webproject.dao.impl.CartDAO;
import com.webproject.model.Cart;
import com.webproject.service.ICartService;

public class CartServiceImpl implements ICartService {
    ICartDAO cartDAO = new CartDAO();

    @Override
    public Cart findById(int id) {
        return cartDAO.findById(id);
    }

    @Override
    public Cart findCartByUserId(int userId) {
        return cartDAO.findCartByUserId(userId);
    }
}
