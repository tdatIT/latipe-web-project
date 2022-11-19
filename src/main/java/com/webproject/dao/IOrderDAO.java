package com.webproject.dao;

import com.webproject.model.Orders;
import com.webproject.model.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IOrderDAO {

    List<Orders> findAll();

    List<Orders> findByUserId(int id);

    List<Orders> findByShopId(int id);

    Orders findById(int id);

    List<Orders> findByDate(Date date);

    boolean insertOrder(Orders orders);

    boolean updateOrder(Orders orders);

    boolean cancelOrder(int id);
    List<Orders> getStatistic(String option, LocalDate date) ;
}
