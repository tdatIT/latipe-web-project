package com.webproject.service.impl;

import com.webproject.dao.IUserLevelDAO;
import com.webproject.dao.impl.UserLevelDAOImpl;
import com.webproject.model.UserLevel;
import com.webproject.service.IUserLevelService;

import java.util.HashMap;
import java.util.List;

public class UserLevelServiceImpl implements IUserLevelService {
    IUserLevelDAO userLevelDAO = new UserLevelDAOImpl();

    @Override
    public List<UserLevel> findAll() {
        return userLevelDAO.findAll();
    }


    @Override
    public UserLevel findById(int id) {
        return userLevelDAO.findById(id);
    }

    @Override
    public UserLevel findByName(String name) {
        return userLevelDAO.findByName(name);
    }

    @Override
    public boolean insertUserLevel(UserLevel userLevel) {
        return userLevelDAO.insertUserLevel(userLevel);
    }

    @Override
    public boolean updateUserLevel(UserLevel userLevel) {
        return userLevelDAO.updateUserLevel(userLevel);
    }

    @Override
    public boolean disableUserLevel(int id) {
        return userLevelDAO.disableUserLevel(id);
    }
    public HashMap<Integer, Object > paginate(String search, int page, int option) { return userLevelDAO.paginate(search, page, option);}
}
