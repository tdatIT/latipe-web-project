package com.webproject.dao;

import com.webproject.model.UserFollowStore;

import java.util.HashMap;
import java.util.List;

public interface IUserFollowStoreDAO {
    List<UserFollowStore> findAll();


    UserFollowStore findById(int id);


    boolean insertUserFollowStore(UserFollowStore UserFollowStore);

    boolean updateUserFollowStore(UserFollowStore UserFollowStore);
    boolean delete(int id);
    public UserFollowStore checkExists(int user, int store);
}
