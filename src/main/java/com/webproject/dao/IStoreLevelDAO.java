package com.webproject.dao;

import com.webproject.model.StoreLevel;

import java.util.List;

public interface IStoreLevelDAO {
    List<StoreLevel> findAll();

    StoreLevel findById(int id);

    StoreLevel findByName(String name);

    boolean insertStoreLevel(StoreLevel category);

    boolean updateStoreLevel(StoreLevel category);

    boolean disableStoreLevel(int id);
}
