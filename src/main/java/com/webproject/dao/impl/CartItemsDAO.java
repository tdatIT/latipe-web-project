package com.webproject.dao.impl;

import com.webproject.dao.ICartItemsDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.CartItems;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CartItemsDAO implements ICartItemsDAO {

    @Override
    public CartItems findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CartItems cartItems = null;
        try {
            cartItems = session.get(CartItems.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cartItems;
    }


    @Override
    public boolean insertCartItems(CartItems cartItems) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(cartItems);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateCartItems(CartItems cartItems) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(cartItems);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return status;
    }

    @Override
    public boolean deleteCartItems(int id) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            CartItems cartItems = session.get(CartItems.class, id);
            session.delete(cartItems);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return status;
    }
}
