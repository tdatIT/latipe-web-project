package com.webproject.service.impl;

import com.webproject.dao.IDeliveryDAO;
import com.webproject.dao.impl.DeliveryDAOImpl;
import com.webproject.model.Delivery;
import com.webproject.service.IDeliveryService;

import java.util.HashMap;
import java.util.List;

public class DeliveryServiceImpl implements IDeliveryService {
    IDeliveryDAO deliveryDAO = new DeliveryDAOImpl();

    @Override
    public List<Delivery> findAll() {
        return deliveryDAO.findAll();
    }


    @Override
    public Delivery findById(int id) {
        return deliveryDAO.findById(id);
    }

    @Override
    public Delivery findByName(String name) {
        return deliveryDAO.findByName(name);
    }

    @Override
    public boolean insertDelivery(Delivery delivery) {
        return deliveryDAO.insertDelivery(delivery);
    }

    @Override
    public boolean updateDelivery(Delivery delivery) {
        return deliveryDAO.updateDelivery(delivery);
    }

    @Override
    public boolean disableDelivery(int id) {
        return deliveryDAO.disableDelivery(id);
    }
    public HashMap<Integer, Object > paginate(String search, int page, int option){ return deliveryDAO.paginate(search, page, option);}
}
