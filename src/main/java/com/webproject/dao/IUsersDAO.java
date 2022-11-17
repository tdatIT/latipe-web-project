package com.webproject.dao;

import com.webproject.model.User;

import java.util.List;

public interface IUsersDAO {
    boolean validate(String email, String password);

    User findById(int id);

    List<User> findByStore(int storeId);

    User getUserByEmail(String email);

    boolean insertNewUser(User user);

    boolean updateUser(User user);

    boolean disableUser(int id);

    boolean updateRole(int id, int role_id);

}
