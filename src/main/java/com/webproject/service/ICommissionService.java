package com.webproject.service;

import com.webproject.model.Commission;

import java.util.HashMap;
import java.util.List;

public interface ICommissionService {
    List<Commission> findAll();


    Commission findById(int id);

    Commission findByName(String name);

    boolean insertCommission(Commission category);

    boolean updateCommission(Commission category);

    boolean disableCommission(int id);

    public HashMap<Integer, Object> paginate(String search, int page, int option);
}
