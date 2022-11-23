package com.webproject.service;

import com.webproject.model.StoreLevel;

import java.util.HashMap;
import java.util.List;

public interface IStoreLevelService {
    List<StoreLevel> findAll();


    StoreLevel findById(int id);

    StoreLevel findByName(String name);

    boolean insertStoreLevel(StoreLevel category);

    boolean updateStoreLevel(StoreLevel category);

    boolean disableStoreLevel(int id);    public HashMap<Integer, Object > paginate(String search,int option, int page);
}
