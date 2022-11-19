package com.webproject.dao.impl;

import com.webproject.dao.IDeliveryDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Delivery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DeliveryDAOImpl implements IDeliveryDAO {

    @Override
    public List<Delivery> findAll() {
        List<Delivery> categories = null;
        String HQL = "from Delivery";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            categories = session.createQuery(HQL).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }


    @Override
    public Delivery findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Delivery category = null;
        try {
            category = session.get(Delivery.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public Delivery findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Delivery category = null;
        try {
            Criteria criteria = session.createCriteria(Delivery.class);
            category = (Delivery) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public boolean insertDelivery(Delivery category) {
        return false;
    }

    @Override
    public boolean updateDelivery(Delivery category) {
        return false;
    }

    @Override
    public boolean disableDelivery(int id) {
        return false;
    }
}
