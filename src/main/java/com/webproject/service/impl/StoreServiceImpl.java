package com.webproject.service.impl;

import com.webproject.dao.IStoreDAO;
import com.webproject.dao.impl.StoreDAOImpl;
import com.webproject.model.Store;
import com.webproject.model.User;
import com.webproject.service.IStoreService;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.HashMap;
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
    @Override
    public List<Store> getStatistic(String option, LocalDate date) {
        return storeDAO.getStatistic(option, date);
    }

    @Override
    public HashMap<Integer, Object> paginate(String search, int option, int page) {
        return storeDAO.paginate(search, option, page);
    }
    @Override
    public boolean setStatus(int id, boolean status) {
        return storeDAO.setStatus(id, status);
    }
}
