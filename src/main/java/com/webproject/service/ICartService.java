package com.webproject.service;

import com.webproject.model.Cart;
import com.webproject.model.CartItems;

public interface ICartService {
    public Cart findById(int id);
}
