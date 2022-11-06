package com.webproject.service;

import com.webproject.model.Store;

import java.util.List;

public interface IStoreService {
    List<Store> findAll();

    Store findById(int id);

    Store findByName(String name);

    Store findByOwnId(int id);

    boolean createStore(Store store);

    boolean updateStore(Store store);

    boolean disableStore(int id);

}
