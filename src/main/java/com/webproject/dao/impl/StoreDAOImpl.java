package com.webproject.dao.impl;

import com.webproject.dao.IStoreDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StoreDAOImpl implements IStoreDAO {
    private SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public List<Store> findAll() {
        List<Store> stores = null;
        String HQL = "from Store";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        stores = session.createQuery(HQL).list();
        tx.commit();
        return stores;
    }

    @Override
    public Store findById(int id) {
        Store store = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        store = session.get(Store.class, id);
        tx.commit();
        return store;
    }

    @Override
    public Store findByName(String name) {
        Store store = null;
        String HQL = "from Store where name = :name";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        store = (Store) session.createQuery(HQL)
                .setParameter("name", name)
                .uniqueResult();
        tx.commit();
        return store;
    }

    @Override
    public Store findByOwnId(int id) {
        Store store = null;
        String HQL = "from Store where ownId = :id";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        store = (Store) session.createQuery(HQL)
                .setParameter("id", id).uniqueResult();
        tx.commit();
        return store;
    }

    @Override
    public boolean createStore(Store store) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(store);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean updateStore(Store store) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(store);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean disableStore(int id) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Store store = session.get(Store.class, id);
            store.setActive(false);
            session.update(store);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }
}
