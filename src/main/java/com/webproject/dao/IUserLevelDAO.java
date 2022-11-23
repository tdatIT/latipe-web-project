package com.webproject.dao;

import com.webproject.model.UserLevel;
import com.webproject.model.Delivery;

import java.util.HashMap;
import java.util.List;

public interface IUserLevelDAO {
    List<UserLevel> findAll();


    UserLevel findById(int id);

    UserLevel findByName(String name);

    boolean insertUserLevel(UserLevel userLevel);

    boolean updateUserLevel(UserLevel userLevel);

    boolean disableUserLevel(int id);
    public HashMap<Integer, Object > paginate(String search, int page, int option);
}
