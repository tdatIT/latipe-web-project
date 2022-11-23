package com.webproject.service;

import com.webproject.model.Delivery;

import java.util.HashMap;
import java.util.List;

public interface IDeliveryService {
    List<Delivery> findAll();


    Delivery findById(int id);

    Delivery findByName(String name);

    boolean insertDelivery(Delivery category);

    boolean updateDelivery(Delivery category);

    boolean disableDelivery(int id);    public HashMap<Integer, Object > paginate(String search, int page, int option);
}
