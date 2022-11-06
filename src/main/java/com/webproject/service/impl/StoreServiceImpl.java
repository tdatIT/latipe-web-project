package com.webproject.service.impl;

import com.webproject.dao.IStoreDAO;
import com.webproject.dao.impl.StoreDAOImpl;
import com.webproject.model.Store;
import com.webproject.service.IStoreService;

import java.util.List;

public class StoreServiceImpl implements IStoreService {
    private IStoreDAO storeDAO = new StoreDAOImpl();

    @Override
    public List<Store> findAll() {
        return storeDAO.findAll();
    }

    @Override
    public Store findById(int id) {
        return storeDAO.findById(id);
    }

    @Override
    public Store findByName(String name) {
        return storeDAO.findByName(name);
    }

    @Override
    public Store findByOwnId(int id) {
        return storeDAO.findByOwnId(id);
    }

    @Override
    public boolean createStore(Store store) {
        return storeDAO.createStore(store);
    }

    @Override
    public boolean updateStore(Store store) {
        return storeDAO.updateStore(store);
    }

    @Override
    public boolean disableStore(int id) {
        return storeDAO.disableStore(id);
    }
}
