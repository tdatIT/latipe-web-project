package com.webproject.service.impl;


import com.webproject.dao.IUserAddressDAO;
import com.webproject.dao.impl.UserAddressDAOImpl;
import com.webproject.model.UserAddress;
import com.webproject.model.UserAddress;
import com.webproject.service.IUserAddressService;

import java.util.HashMap;
import java.util.List;

public class UserAddressServiceImpl implements IUserAddressService {
    IUserAddressDAO userAddressDAO= new UserAddressDAOImpl();

    @Override
    public List<UserAddress> findAll() {
        return userAddressDAO.findAll();
    }
    

    @Override
    public UserAddress findById(int id) {
        return userAddressDAO.findById(id);
    }

    @Override
    public UserAddress findByName(String name) {
        return userAddressDAO.findByName(name);
    }

    @Override
    public boolean insertUserAddress(UserAddress category) {
        return userAddressDAO.insertUserAddress(category);
    }

    @Override
    public boolean updateUserAddress(UserAddress category) {
        return userAddressDAO.updateUserAddress(category);
    }

    @Override
    public boolean deleteUserAddress(int id) {
        return userAddressDAO.deleteUserAddress(id);
    }
    @Override
    public HashMap<Integer, Object > paginate(String search, int option, int page){ return userAddressDAO.paginate(search,option, page);}


    public boolean setStatus(int id, boolean status) {
        return userAddressDAO.setStatus(id, status);
    }
}
