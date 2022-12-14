package com.webproject.dao;

import com.webproject.model.CartItems;

public interface ICartItemsDAO {

    public CartItems findById(int id);

    public boolean insertCartItems(CartItems product);

    public boolean updateCartItems(CartItems product);

    public boolean deleteCartItems(int id);

}
