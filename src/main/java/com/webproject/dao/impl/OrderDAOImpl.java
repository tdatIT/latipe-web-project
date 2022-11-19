package com.webproject.dao.impl;

import com.webproject.dao.IOrderDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Orders;
import com.webproject.model.Orders;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    @Override
    public List<Orders> getStatistic(String option, LocalDate date) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Orders.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 0 nam, 1 thang, 2 7 ngay truoc, 3 ngay
        switch (option) {
            case "0": {
                LocalDate fromDate = LocalDate.parse(date.getYear() + "-01-01" + " 00:00:00");
                LocalDate toDate = LocalDate.parse(date.getYear() + "-12-31" + " 23:59:59");
                cr.add(Restrictions.between("createDate", fromDate, toDate));
            }
            case "1": {
                LocalDate fromDate = LocalDate.parse(date.getYear() + "-" + date.getMonth() + "-01" + " 00:00:00");
                LocalDate toDate = LocalDate.parse((date.getYear() + "-" + date.getMonth() + 1 + "-01" + " 00:00:00"));
                cr.add(Restrictions.between("createDate", fromDate, toDate));
            }
            case "2": {
                cr.add(Restrictions.between("createDate", date.minusDays(7), date));
            }
            case "3": {
                cr.add(Restrictions.between("createDate", date.minusDays(1), date));
            }
        }
        List<Orders> results = null;
        try {
            results = cr.list();
        } catch (Exception e) {
            //roll back trans when insert failed
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
