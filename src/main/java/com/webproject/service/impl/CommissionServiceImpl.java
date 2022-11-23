package com.webproject.service.impl;

import com.webproject.dao.ICommissionDAO;
import com.webproject.dao.impl.CommissionDAOImpl;
import com.webproject.model.Commission;
import com.webproject.service.ICommissionService;

import java.util.HashMap;
import java.util.List;

public class CommissionServiceImpl implements ICommissionService {
    ICommissionDAO commissionDAO = new CommissionDAOImpl();

    @Override
    public List<Commission> findAll() {
        return commissionDAO.findAll();
    }


    @Override
    public Commission findById(int id) {
        return commissionDAO.findById(id);
    }

    @Override
    public Commission findByName(String name) {
        return commissionDAO.findByName(name);
    }

    @Override
    public boolean insertCommission(Commission commission) {
        return commissionDAO.insertCommission(commission);
    }

    @Override
    public boolean updateCommission(Commission commission) {
        return commissionDAO.updateCommission(commission);
    }

    @Override
    public boolean disableCommission(int id) {
        return commissionDAO.disableCommission(id);
    }
    public HashMap<Integer, Object > paginate(String search, int page, int option) { return commissionDAO.paginate(search, page, option);}
}
