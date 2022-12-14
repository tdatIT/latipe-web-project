package com.webproject.service.impl;

import com.webproject.dao.ICartItemsDAO;
import com.webproject.dao.impl.CartItemsDAO;
import com.webproject.model.CartItems;
import com.webproject.service.ICartItemsService;

public class CartItemsServiceImpl implements ICartItemsService {
    ICartItemsDAO com = new CartItemsDAO();
    @Override
    public CartItems findById(int id) {
        return com.findById(id);
    }

    @Override
    public boolean insertCartItems(CartItems cartItems) {
        return com.insertCartItems(cartItems);
    }

    @Override
    public boolean updateCartItems(CartItems cartItems) {
        return com.updateCartItems(cartItems);
    }

    @Override
    public boolean deleteCartItems(int id) {
        return com.deleteCartItems(id);
    }
}
