package com.webproject.service;

import com.webproject.model.UserFollowProduct;

import java.util.List;

public interface IUserFollowProductService {
    List<UserFollowProduct> findAll();


    UserFollowProduct findById(int id);


    boolean insertUserFollowProduct(UserFollowProduct UserFollowProduct);

    boolean updateUserFollowProduct(UserFollowProduct UserFollowProduct);
    boolean delete(int id);
    public UserFollowProduct checkExists(int user, int product);
}
