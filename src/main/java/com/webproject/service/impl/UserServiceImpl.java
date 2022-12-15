package com.webproject.service.impl;

import com.webproject.dao.IUsersDAO;
import com.webproject.dao.impl.UserDAOImpl;
import com.webproject.model.User;
import com.webproject.service.IUserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUsersDAO usersDAO = new UserDAOImpl();

    @Override
    public User findById(int id) {
        return usersDAO.findById(id);
    }

    @Override
    public List<User> findByStore(int storeId) {
        return usersDAO.findByStore(storeId);
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

    @Override
    public List<User> getStatistic(String option, LocalDate date) {
        return usersDAO.getStatistic(option, date);
    }

    @Override
    public HashMap<Integer, Object> paginate(String search, int option, int page) {
        return usersDAO.paginate(search, option, page);
    }

    @Override
    public boolean setStatus(int id, boolean status) {
        return usersDAO.setStatus(id, status);
    }

    @Override
    public List<User> findAll() {
        return usersDAO.findAll();
    }

    public String resetPassword(String email) {
        return usersDAO.resetPassword(email);
    }
}
