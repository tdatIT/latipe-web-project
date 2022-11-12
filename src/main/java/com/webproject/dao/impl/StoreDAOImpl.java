package com.webproject.dao.impl;

import com.webproject.dao.IStoreDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Store;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
