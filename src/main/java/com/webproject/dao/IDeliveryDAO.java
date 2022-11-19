package com.webproject.dao;

import com.webproject.model.Delivery;

import java.util.List;

public interface IDeliveryDAO {
    List<Delivery> findAll();

    Delivery findById(int id);

    Delivery findByName(String name);

    boolean insertDelivery(Delivery category);

    boolean updateDelivery(Delivery category);

    boolean disableDelivery(int id);
}
