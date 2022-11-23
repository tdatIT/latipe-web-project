package com.webproject.service;

import com.webproject.model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface IUserService {

    User findById(int id);

    List<User> findByStore(int storeId);

    boolean validate(String email, String password);

    User getUserByEmail(String email);

    boolean insertNewUser(User user);

    boolean updateUser(User user);

    boolean disableUser(int id);

    List<User> findAll();

    List<User> getStatistic(String option, LocalDate date);

    public HashMap<Integer, Object> paginate(String search, int option, int page);

    public boolean setStatus(int id, boolean status);

}
