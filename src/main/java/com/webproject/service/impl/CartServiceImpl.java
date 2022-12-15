package com.webproject.service.impl;

import com.webproject.dao.ICartDAO;
import com.webproject.dao.ICartItemsDAO;
import com.webproject.dao.impl.CartDAO;
import com.webproject.dao.impl.CartItemsDAO;
import com.webproject.model.Cart;
import com.webproject.model.CartItems;
import com.webproject.service.ICartService;

public class CartServiceImpl implements ICartService {
    ICartDAO cartDAO = new CartDAO();
    ICartItemsDAO cartItemsDAO = new CartItemsDAO();

    @Override
    public Cart findById(int id) {
        return cartDAO.findById(id);
    }

    @Override
    public Cart findCartByUserId(int userId) {
        return cartDAO.findCartByUserId(userId);
    }

    @Override
    public void deletedItems(Cart cart) {
        for (CartItems i : cart.getCartItemsByCartId()) {
            cartItemsDAO.deleteCartItems(i.getId());
        }
    }
}
