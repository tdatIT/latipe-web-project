package com.webproject.service;

import com.webproject.model.User;

public interface IUserService {
    User findById(int id);
    boolean validate(String email, String password);

    User getUserByEmail(String email);

    boolean insertNewUser(User user);

    boolean updateUser(User user);

    boolean disableUser(int id);
}
