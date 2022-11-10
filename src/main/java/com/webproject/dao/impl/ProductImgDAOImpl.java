package com.webproject.dao.impl;

import com.webproject.dao.IProductImgDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.ProductImg;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class IProductImgDAOImpl implements IProductImgDAO {
    private SessionFactory factory;

    @Override
    public ProductImg getImageById(int id) {
        factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        ProductImg img = session.get(ProductImg.class, id);
        tx.commit();
        return img;
    }

    @Override
    public void insertProductImage(ProductImg img) {
        factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(img);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }

    }
}
