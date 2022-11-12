package com.webproject.service.impl;

import com.webproject.dao.IOrderDAO;
import com.webproject.dao.impl.OrderDAOImpl;
import com.webproject.model.Orders;
import com.webproject.service.IOrderService;

import java.sql.Date;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    private IOrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public List<Orders> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public List<Orders> findByUserId(int id) {
        return orderDAO.findByUserId(id);
    }

    @Override
    public List<Orders> findByShopId(int id) {
        return orderDAO.findByShopId(id);
    }

    @Override
    public Orders findById(int id) {
        return orderDAO.findById(id);
    }

    @Override
    public List<Orders> findByDate(Date date) {
        return orderDAO.findByDate(date);
    }

    @Override
    public boolean insertOrder(Orders orders) {
        return orderDAO.insertOrder(orders);
    }

    @Override
    public boolean updateOrder(Orders orders) {
        return orderDAO.updateOrder(orders);
    }

    @Override
    public boolean cancelOrder(int id) {
        return orderDAO.cancelOrder(id);
    }
}
