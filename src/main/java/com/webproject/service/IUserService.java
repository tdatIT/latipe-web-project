package com.webproject.service;

import com.webproject.model.User;

import java.util.List;

public interface IUserService {
    User findById(int id);

    List<User> findByStore(int storeId);


    boolean validate(String email, String password);

    User getUserByEmail(String email);

    boolean insertNewUser(User user);

    boolean updateUser(User user);

    boolean disableUser(int id);
}
