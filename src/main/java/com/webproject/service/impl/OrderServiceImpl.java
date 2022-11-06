package com.webproject.service.impl;

import com.webproject.dao.IOrderDAO;
import com.webproject.dao.impl.OrderDAOImpl;
import com.webproject.model.Order;
import com.webproject.service.IOrderService;

import java.sql.Date;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    private IOrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public List<Order> findByUserId(int id) {
        return orderDAO.findByUserId(id);
    }

    @Override
    public List<Order> findByShopId(int id) {
        return orderDAO.findByShopId(id);
    }

    @Override
    public Order findById(int id) {
        return orderDAO.findById(id);
    }

    @Override
    public List<Order> findByDate(Date date) {
        return orderDAO.findByDate(date);
    }

    @Override
    public boolean insertOrder(Order order) {
        return orderDAO.insertOrder(order);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public boolean cancelOrder(int id) {
        return orderDAO.cancelOrder(id);
    }
}
