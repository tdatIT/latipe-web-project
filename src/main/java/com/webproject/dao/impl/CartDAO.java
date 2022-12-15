package com.webproject.dao.impl;

import com.webproject.dao.ICartDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Cart;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class CartDAO implements ICartDAO {
    @Override
    public Cart findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Cart cartItems = null;
        try {
            cartItems = session.get(Cart.class, id);
            Hibernate.initialize(cartItems.getCartItemsByCartId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cartItems;
    }

    @Override
    public Cart findCartByUserId(int userId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Cart cart = null;
        try {
            String HQL = "from Cart where userId = :id";
            cart = (Cart) session.createQuery(HQL)
                    .setParameter("id", userId)
                    .uniqueResult();
            Hibernate.initialize(cart.getCartItemsByCartId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cart;
    }
}
