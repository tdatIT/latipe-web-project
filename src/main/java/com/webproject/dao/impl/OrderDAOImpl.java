package com.webproject.dao.impl;

import com.webproject.dao.IOrderDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class OrderDAOImpl implements IOrderDAO {
    private SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public List<Order> findAll() {
        List<Order> orders = null;
        String HQL = "from Order";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL).list();
        tx.commit();
        return orders;
    }

    @Override
    public List<Order> findByUserId(int id) {
        List<Order> orders = null;
        String HQL = "from Order where userId = :id";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL)
                .setParameter("id", id).list();
        tx.commit();
        return orders;
    }

    @Override
    public List<Order> findByShopId(int id) {
        List<Order> orders = null;
        String HQL = "from Order where storeId = :id";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL)
                .setParameter("id", id).list();
        tx.commit();
        return orders;
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            order = session.get(Order.class, id);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> findByDate(Date date) {
        List<Order> orders = null;
        String HQL = "from Order where createDate = :date";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL)
                .setParameter("date", date).list();
        tx.commit();
        return orders;
    }

    @Override
    public boolean insertOrder(Order order) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(order);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean updateOrder(Order order) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(order);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean cancelOrder(int id) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Order order = session.get(Order.class, id);
            order.setStatus(0);
            session.update(order);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;

    }
}
