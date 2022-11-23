package com.webproject.service.impl;

import com.webproject.dao.IStoreLevelDAO;
import com.webproject.dao.impl.StoreLevelDAOImpl;
import com.webproject.model.StoreLevel;
import com.webproject.service.IStoreLevelService;

import java.util.HashMap;
import java.util.List;

public class StoreLevelServiceImpl implements IStoreLevelService {
    IStoreLevelDAO storeLevelDAO = new StoreLevelDAOImpl();

    @Override
    public List<StoreLevel> findAll() {
        return storeLevelDAO.findAll();
    }


    @Override
    public StoreLevel findById(int id) {
        return storeLevelDAO.findById(id);
    }

    @Override
    public StoreLevel findByName(String name) {
        return storeLevelDAO.findByName(name);
    }

    @Override
    public boolean insertStoreLevel(StoreLevel storeLevel) {
        return storeLevelDAO.insertStoreLevel(storeLevel);
    }

    @Override
    public boolean updateStoreLevel(StoreLevel storeLevel) {
        return storeLevelDAO.updateStoreLevel(storeLevel);
    }

    @Override
    public boolean disableStoreLevel(int id) {
        return storeLevelDAO.disableStoreLevel(id);
    }
    public HashMap<Integer, Object > paginate(String search,int option, int page){ return storeLevelDAO.paginate(search, option, page);}
}
