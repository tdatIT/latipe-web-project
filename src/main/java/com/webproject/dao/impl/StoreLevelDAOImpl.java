package com.webproject.dao.impl;

import com.webproject.dao.IStoreLevelDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.StoreLevel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class StoreLevelDAOImpl implements IStoreLevelDAO {

    @Override
    public List<StoreLevel> findAll() {
        List<StoreLevel> categories = null;
        String HQL = "from StoreLevel";
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
    public StoreLevel findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        StoreLevel category = null;
        try {
            category = session.get(StoreLevel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public StoreLevel findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        StoreLevel category = null;
        try {
            Criteria criteria = session.createCriteria(StoreLevel.class);
            category = (StoreLevel) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public boolean insertStoreLevel(StoreLevel category) {
        return false;
    }

    @Override
    public boolean updateStoreLevel(StoreLevel category) {
        return false;
    }

    @Override
    public boolean disableStoreLevel(int id) {
        return false;
    }
}
