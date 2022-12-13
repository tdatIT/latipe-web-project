package com.webproject.service.impl;

import com.webproject.dao.IUserFollowProductDAO;
import com.webproject.dao.impl.UserFollowProductDAOImpl;
import com.webproject.model.UserFollowProduct;
import com.webproject.service.IUserFollowProductService;

import java.util.List;

public class UserFollowProductServiceImpl implements IUserFollowProductService {

    private final IUserFollowProductDAO uow = new UserFollowProductDAOImpl();

    @Override
    public List<UserFollowProduct> findAll() {
        return uow.findAll();
    }

    @Override
    public UserFollowProduct findById(int id) {
        return uow.findById(id);
    }

    @Override
    public boolean insertUserFollowProduct(UserFollowProduct UserFollowProduct) {
        return uow.insertUserFollowProduct(UserFollowProduct);
    }

    @Override
    public boolean updateUserFollowProduct(UserFollowProduct UserFollowProduct) {
        return uow.updateUserFollowProduct(UserFollowProduct);
    }

    @Override
    public boolean delete(int id) {
        return uow.delete(id);
    }

    @Override
    public UserFollowProduct checkExists(int user, int product) {
        return uow.checkExists(user, product);
    }
}
