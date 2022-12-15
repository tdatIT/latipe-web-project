package com.webproject.dao;

import com.webproject.model.User;
import com.webproject.model.UserLevel;

import java.time.LocalDate;
import java.util.HashMap;
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

    List<User> getStatistic(String option, LocalDate date);

    List<User> findAll();

    public HashMap<Integer, Object> paginate(String search, int option, int page);

    public boolean setStatus(int id, boolean status);
    public String resetPassword(String email);

}
