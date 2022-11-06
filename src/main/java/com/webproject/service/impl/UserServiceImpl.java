package com.webproject.service.impl;

import com.webproject.dao.IUsersDAO;
import com.webproject.dao.impl.UserDAOImpl;
import com.webproject.model.User;
import com.webproject.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUsersDAO usersDAO = new UserDAOImpl();

    @Override
    public User findById(int id) {
        return usersDAO.findById(id);
    }

    @Override
    public boolean validate(String email, String password) {
        return usersDAO.validate(email, password);
    }

    @Override
    public User getUserByEmail(String email) {
        return usersDAO.getUserByEmail(email);
    }

    @Override
    public boolean insertNewUser(User user) {
        return usersDAO.insertNewUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return usersDAO.updateUser(user);
    }

    @Override
    public boolean disableUser(int id) {
        return usersDAO.disableUser(id);
    }
}
