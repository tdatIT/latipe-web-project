package com.webproject.service;

import com.webproject.model.UserLevel;

import java.util.HashMap;
import java.util.List;

public interface IUserLevelService {
    List<UserLevel> findAll();


    UserLevel findById(int id);

    UserLevel findByName(String name);

    boolean insertUserLevel(UserLevel category);

    boolean updateUserLevel(UserLevel category);

    boolean disableUserLevel(int id);    public HashMap<Integer, Object > paginate(String search, int page, int option);
}
