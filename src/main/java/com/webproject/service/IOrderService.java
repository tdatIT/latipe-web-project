package com.webproject.service;

import com.webproject.model.Orders;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IOrderService {
    List<Orders> findAll();

    List<Orders> findByUserId(int id);

    List<Orders> findByShopId(int id);

    Orders findById(int id);

    List<Orders> findByDate(Date date);

    List<Orders> findOrderByStatus(int shopId,int status);


    boolean insertOrder(Orders orders);

    boolean updateOrder(Orders orders);

    boolean cancelOrder(int id);

    Map<Integer, Long> totalOrdersFromStore5Month(int shopId, Date date);

    Map<Integer, Double> totalAmountsFromStore5Month(int storeId, Date date);

    Map<String, Long> totalProductInMonth(int storeId, Date date);

    List<Orders> getStatistic(String option, LocalDate date);

    public HashMap<Integer, Object> paginate(String search, int page, int status);

    public boolean setStatus(int id, int status);
}
