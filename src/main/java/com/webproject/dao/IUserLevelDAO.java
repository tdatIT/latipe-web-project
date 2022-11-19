package com.webproject.dao;

import com.webproject.model.UserLevel;

import java.util.List;

public interface IUserLevelDAO {
    List<UserLevel> findAll();

    UserLevel findById(int id);

    UserLevel findByName(String name);

    boolean insertUserLevel(UserLevel category);

    boolean updateUserLevel(UserLevel category);

    boolean disableUserLevel(int id);
}
