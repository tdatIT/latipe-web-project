package com.webproject.service.impl;

import com.webproject.dao.IStoreDAO;
import com.webproject.dao.IUserFollowStoreDAO;
import com.webproject.dao.impl.StoreDAOImpl;
import com.webproject.dao.impl.UserFollowStoreDAOImpl;
import com.webproject.model.UserFollowStore;
import com.webproject.service.IUserFollowStoreService;

import java.util.List;

public class UserFollowStoreServiceImpl implements IUserFollowStoreService {

    private IUserFollowStoreDAO uow = new UserFollowStoreDAOImpl();
    @Override
    public List<UserFollowStore> findAll() {
        return uow.findAll();
    }

    @Override
    public UserFollowStore findById(int id) {
        return uow.findById(id);
    }

    @Override
    public boolean insertUserFollowStore(UserFollowStore UserFollowStore) {
        return uow.insertUserFollowStore(UserFollowStore);
    }

    @Override
    public boolean updateUserFollowStore(UserFollowStore UserFollowStore) {
        return uow.updateUserFollowStore(UserFollowStore);
    }

    @Override
    public boolean delete(int id) {
        return uow.delete(id);
    }
    @Override
    public UserFollowStore checkExists(int user, int store){
        return uow.checkExists(user,store);
    }
}
