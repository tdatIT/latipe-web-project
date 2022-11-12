package com.webproject.dao.impl;

import com.webproject.dao.IOrderDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Orders;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class OrderDAOImpl implements IOrderDAO {
    private SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public List<Orders> findAll() {
        List<Orders> orders = null;
        String HQL = "from Orders";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL).list();
        tx.commit();
        return orders;
    }

    @Override
    public List<Orders> findByUserId(int id) {
        List<Orders> orders = null;
        String HQL = "from Orders where userId = :id";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL)
                .setParameter("id", id).list();
        tx.commit();
        return orders;
    }

    @Override
    public List<Orders> findByShopId(int id) {
        List<Orders> orders = null;
        String HQL = "from Orders where storeId = :id";
        Session session = HibernateUtils.getSessionFactory().getSessionFactory().openSession();
        try {
            orders = session.createQuery(HQL)
                    .setParameter("id", id).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Orders findById(int id) {
        Orders orders = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            orders = session.get(Orders.class, id);
            Hibernate.initialize(orders.getOrderItemsByOrderId());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public List<Orders> findByDate(Date date) {
        List<Orders> orders = null;
        String HQL = "from Orders where createDate = :date";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL)
                .setParameter("date", date).list();
        tx.commit();
        return orders;
    }

    @Override
    public boolean insertOrder(Orders orders) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(orders);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean updateOrder(Orders orders) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(orders);
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
            Orders orders = session.get(Orders.class, id);
            orders.setStatus(0);
            session.update(orders);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;

    }
}
