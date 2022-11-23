package com.webproject.dao.impl;

import com.webproject.dao.IDeliveryDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Delivery;
import com.webproject.model.Delivery;
import com.webproject.model.Store;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class DeliveryDAOImpl implements IDeliveryDAO {
    private SessionFactory factory;
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
        factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            category.setCreateDate(new Date(new java.util.Date().getTime()));
            session.save(category);
            tx.commit();
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateDelivery(Delivery category) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        boolean status = false;
        try {
            session.update(category);
            tx.commit();
            status= true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return status;
    }

    @Override
    public boolean disableDelivery(int id) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Delivery store = session.get(Delivery.class, id);
            store.setDeleted(true);
            session.update(store);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return status;
    }

    @Override
    public HashMap<Integer, Object> paginate(String search, int page, int option) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Delivery> data = null;
        int count = 0;
        try {
            //get paginate
            Criteria criteria = session.createCriteria(Delivery.class);
            criteria.setMaxResults(10 * page + 10);
            criteria.setFirstResult(10 * page);
            if (option == 1)
                criteria.add(Restrictions.eq("isDeleted", false));
            else if (option == 2)
                criteria.add(Restrictions.eq("isDeleted", true));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            data = criteria.list();

            //count
            criteria = session.createCriteria(Delivery.class);
            if (option == 1)
                criteria.add(Restrictions.eq("isDeleted", false));
            else if (option == 2)
                criteria.add(Restrictions.eq("isDeleted", true));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            count = criteria.list().size();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        HashMap<Integer, Object> results = new HashMap<Integer, Object>();
        results.put(count, data);
        return results;
    }
}
