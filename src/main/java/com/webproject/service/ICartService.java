package com.webproject.service;

import com.webproject.model.Cart;

public interface ICartService {
    public Cart findById(int id);

    Cart findCartByUserId(int userId);
}
