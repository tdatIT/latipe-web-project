package com.webproject.dao.impl;

import com.webproject.dao.IProductImgDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.ProductImg;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductImgDAOImpl implements IProductImgDAO {
    private SessionFactory factory;

    @Override
    public ProductImg getImageById(int id) {
        factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        ProductImg img = null;
        try {
            img = session.get(ProductImg.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return img;
    }

    @Override
    public void insertProductImage(ProductImg img) {
        factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(img);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }

    }
}
