package com.webproject.dao;

import com.webproject.model.Store;
import com.webproject.model.StoreLevel;
import com.webproject.model.User;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface IStoreDAO {
    List<Store> findAll();
    Store findById(int id);
    Store findByName(String name);
    Store findByOwnId(int id);
    boolean createStore(Store store);
    boolean updateStore(Store store);
    boolean disableStore(int id);
    List<Store> getStatistic(String option, LocalDate date) ;

    public HashMap<Integer, Object > paginate(String search,int option, int page);

    public boolean setStatus(int id, boolean status);
}
