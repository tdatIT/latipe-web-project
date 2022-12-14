package com.webproject.service;

import com.webproject.model.CartItems;

public interface ICartItemsService {

    public CartItems findById(int id);

    public boolean insertCartItems(CartItems product);

    public boolean updateCartItems(CartItems product);

    public boolean deleteCartItems(int id);
}
