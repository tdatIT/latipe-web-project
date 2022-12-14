package com.webproject.dao.impl;

import com.webproject.dao.IStoreLevelDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.StoreLevel;
import com.webproject.model.Store;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class StoreLevelDAOImpl implements IStoreLevelDAO {
    private SessionFactory factory;

    @Override
    public List<StoreLevel> findAll() {
        List<StoreLevel> storeLevels = null;
        String HQL = "from StoreLevel";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            storeLevels = session.createQuery(HQL).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return storeLevels;
    }


    @Override
    public StoreLevel findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        StoreLevel storeLevel = null;
        try {
            storeLevel = session.get(StoreLevel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return storeLevel;
    }

    @Override
    public StoreLevel findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        StoreLevel storeLevel = null;
        try {
            Criteria criteria = session.createCriteria(StoreLevel.class);
            storeLevel = (StoreLevel) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return storeLevel;
    }

    @Override
    public boolean insertStoreLevel(StoreLevel storeLevel) {
        factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(storeLevel);
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
    public boolean updateStoreLevel(StoreLevel storeLevel) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(storeLevel);
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
    public boolean disableStoreLevel(int id) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            StoreLevel store = session.get(StoreLevel.class, id);
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
    @Transactional
    public HashMap<Integer, Object> paginate(String search, int page, int option) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<StoreLevel> data = null;
        int count = 0;
        try {
            //get paginate

            Criteria criteria = session.createCriteria(StoreLevel.class);
            criteria.setMaxResults(10 * page + 10);
            criteria.setFirstResult(10 * page);
            if (option == 1)
                criteria.add(Restrictions.eq("isDeleted", false));
            else if (option == 2)
                criteria.add(Restrictions.eq("isDeleted", true));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            data = criteria.list();

            //count
            criteria = session.createCriteria(StoreLevel.class);
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
