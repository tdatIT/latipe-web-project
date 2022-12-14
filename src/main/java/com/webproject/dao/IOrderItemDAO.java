package com.webproject.dao;

import com.webproject.model.OrderItems;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface IOrderItemDAO {
    public List<OrderItems> findAll();

    public OrderItems findById(int id);

    public OrderItems findByName(String name);

    public int insertOrderItems(OrderItems product);

    public boolean updateOrderItems(OrderItems product);

    public boolean deleteOrderItems(int id, boolean status);

}
