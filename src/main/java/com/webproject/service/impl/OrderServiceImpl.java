package com.webproject.service.impl;

import com.webproject.dao.IOrderDAO;
import com.webproject.dao.impl.OrderDAOImpl;
import com.webproject.model.Orders;
import com.webproject.service.IOrderService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public Map<Integer, Long> totalOrdersFromStore5Month(int shopId, Date date) {
        List<Objects[]> list = orderDAO.totalOrdersFromStore5Month(shopId, date);
        Map<Integer, Long> data = new HashMap<>();
        for (Object[] o : list) {
            data.put((Integer) o[0], (Long) o[1]);
        }
        return data;
    }

    @Override
    public Map<Integer, Double> totalAmountsFromStore5Month(int storeId, Date date) {
        List<Objects[]> list = orderDAO.totalAmountsFromStore5Month(storeId, date);
        Map<Integer, Double> data = new HashMap<>();
        for (Object[] o : list) {
            data.put((Integer) o[0], (Double) o[1]);
        }
        return data;
    }

    @Override
    public Map<String, Long> totalProductInMonth(int storeId, Date date) {
        List<Objects[]> list = orderDAO.totalProductInMonth(storeId, date);
        Map<String, Long> data = new HashMap<>();
        for (Object[] o : list) {
            data.put((String) o[0], (Long) o[1]);
        }
        return data;
    }
}
