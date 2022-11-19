package com.webproject.dao.impl;

import com.webproject.dao.IStoreDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Store;
import com.webproject.model.Store;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class StoreDAOImpl implements IStoreDAO {
    @Override
    public List<Store> findAll() {
        List<Store> stores = null;
        String HQL = "from Store";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            stores = session.createQuery(HQL).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return stores;
    }

    @Override
    public Store findById(int id) {
        Store store = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            store = session.get(Store.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return store;
    }

    @Override
    public Store findByName(String name) {
        Store store = null;
        String HQL = "from Store where name = :name";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            store = (Store) session.createQuery(HQL)
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return store;
    }

    @Override
    public Store findByOwnId(int id) {
        Store store = null;
        String HQL = "from Store where ownId = :id";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            store = (Store) session.createQuery(HQL)
                    .setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return store;
    }

    @Override
    public boolean createStore(Store store) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(store);
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
    public boolean updateStore(Store store) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(store);
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
    public boolean disableStore(int id) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Store store = session.get(Store.class, id);
            store.setActive(false);
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
    public List<Store> getStatistic(String option, LocalDate date) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Store.class);
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
        List<Store> results = null;
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
