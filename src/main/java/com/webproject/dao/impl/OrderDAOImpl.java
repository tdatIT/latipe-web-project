package com.webproject.dao.impl;

import com.webproject.dao.IOrderDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Orders;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL)
                .setParameter("date", date).list();
        tx.commit();
        return orders;
    }

    @Override
    public boolean insertOrder(Orders orders) {
        boolean status = false;
        Session session = factory.openSession();
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
        Session session = factory.openSession();
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
        Session session = factory.openSession();
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
    public List<Objects[]> totalOrdersFromStore5Month(int storeId, Date date) {
        List<Objects[]> orderToMonth = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            String HQL = "select month(o.createDate),count(*) from Orders o " +
                    "where ((MONTH(o.createDate)<= :_start AND MONTH(o.createDate)>=:_end) AND YEAR(o.createDate)=:year)" +
                    "AND o.storeId =:storeId  group by " +
                    "month(o.createDate) order by MONTH(o.createDate) DESC ";
            orderToMonth = session.createQuery(HQL)
                    .setParameter("storeId", storeId)
                    .setParameter("_start", date.toLocalDate().getMonthValue())
                    .setParameter("_end", date.toLocalDate().getMonthValue() - 5)
                    .setParameter("year", date.toLocalDate().getYear())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderToMonth;
    }

    @Override
    public List<Objects[]> totalAmountsFromStore5Month(int storeId, Date date) {
        List<Objects[]> orderToMonth = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            String HQL = "select month(o.createDate),sum(o.amountFromStore) from Orders o " +
                    "where ((MONTH(o.createDate)<= :_start AND MONTH(o.createDate)>=:_end) AND YEAR(o.createDate)=:year)" +
                    "AND o.storeId =:storeId  group by " +
                    "month(o.createDate) order by MONTH(o.createDate) DESC ";
            orderToMonth = session.createQuery(HQL)
                    .setParameter("storeId", storeId)
                    .setParameter("_start", date.toLocalDate().getMonthValue())
                    .setParameter("_end", date.toLocalDate().getMonthValue() - 5)
                    .setParameter("year", date.toLocalDate().getYear())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderToMonth;
    }

    @Override
    public List<Objects[]> totalProductInMonth(int storeId, Date date) {
        List<Objects[]> orderToMonth = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            String HQL = "select i.productByProductId.name,count(*) " +
                    "from OrderItems i inner join i.orderByOrderId " +
                    "where ((month (i.orderByOrderId.createDate)<= :_start and month(i.orderByOrderId.createDate)>=:_end) " +
                    "and year(i.orderByOrderId.createDate)=:year)" +
                    "and i.orderByOrderId.storeId=:storeId " +
                    "group by i.productId";
            orderToMonth = session.createQuery(HQL)
                    .setParameter("storeId", storeId)
                    .setParameter("_start", date.toLocalDate().getMonthValue())
                    .setParameter("_end", date.toLocalDate().getMonthValue() - 1)
                    .setParameter("year", date.toLocalDate().getYear())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderToMonth;
    }
}
