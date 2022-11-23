package com.webproject.dao;

import com.webproject.model.Commission;
import com.webproject.model.Delivery;

import java.util.HashMap;
import java.util.List;

public interface ICommissionDAO {
    List<Commission> findAll();


    Commission findById(int id);

    Commission findByName(String name);

    boolean insertCommission(Commission category);

    boolean updateCommission(Commission category);

    boolean disableCommission(int id);
    public HashMap<Integer, Object > paginate(String search, int page, int option);
}
