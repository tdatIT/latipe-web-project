package com.webproject.dao;

import com.webproject.model.Order;

import java.sql.Date;
import java.util.List;

public interface IOrderDAO {

    List<Order> findAll();

    List<Order> findByUserId(int id);

    List<Order> findByShopId(int id);

    Order findById(int id);

    List<Order> findByDate(Date date);

    boolean insertOrder(Order order);

    boolean updateOrder(Order order);

    boolean cancelOrder(int id);

}
