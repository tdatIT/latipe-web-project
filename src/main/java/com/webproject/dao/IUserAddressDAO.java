package com.webproject.dao;

import com.webproject.model.Category;
import com.webproject.model.UserAddress;

import java.util.HashMap;
import java.util.List;

public interface IUserAddressDAO {
    List<UserAddress> findAll();

    UserAddress findById(int id);

    UserAddress findByName(String name);

    boolean insertUserAddress(UserAddress useraddress);

    boolean updateUserAddress(UserAddress useraddress);

    boolean deleteUserAddress(int id);
    public boolean setStatus(int id, boolean status);

    HashMap<Integer, Object> paginate(String search, int page, int option);
}
