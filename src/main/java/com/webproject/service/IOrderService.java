package com.webproject.service;

import com.webproject.model.Orders;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface IOrderService {
    List<Orders> findAll();

    List<Orders> findByUserId(int id);

    List<Orders> findByShopId(int id);

    Orders findById(int id);

    List<Orders> findByDate(Date date);

    boolean insertOrder(Orders orders);

    boolean updateOrder(Orders orders);

    boolean cancelOrder(int id);

    Map<Integer, Long> totalOrdersFromStore5Month(int shopId, Date date);

    Map<Integer, Double> totalAmountsFromStore5Month(int storeId, Date date);

    Map<String, Long> totalProductInMonth(int storeId, Date date);
}
