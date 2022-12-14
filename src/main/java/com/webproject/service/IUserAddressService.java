package com.webproject.service;

import com.webproject.model.UserAddress;

import java.util.HashMap;
import java.util.List;

public interface IUserAddressService {
    List<UserAddress> findAll();

    UserAddress findById(int id);

    UserAddress findByName(String name);

    boolean insertUserAddress(UserAddress category);

    boolean updateUserAddress(UserAddress category);

    boolean deleteUserAddress(int id);

    HashMap<Integer, Object> paginate(String search, int option, int page);

    public boolean setStatus(int id, boolean status);
}
