package com.webproject.dao;

import com.webproject.model.StoreLevel;
import com.webproject.model.Delivery;

import java.util.HashMap;
import java.util.List;

public interface IStoreLevelDAO {
    List<StoreLevel> findAll();


    StoreLevel findById(int id);

    StoreLevel findByName(String name);

    boolean insertStoreLevel(StoreLevel storeLevel);

    boolean updateStoreLevel(StoreLevel storeLevel);

    boolean disableStoreLevel(int id);
    public HashMap<Integer, Object > paginate(String search, int page, int option);
}
