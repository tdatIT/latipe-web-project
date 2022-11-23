package com.webproject.dao.impl;

import com.webproject.dao.IUserLevelDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.UserLevel;
import com.webproject.model.UserLevel;
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

public class UserLevelDAOImpl implements IUserLevelDAO {
    private SessionFactory factory;
    @Override
    public List<UserLevel> findAll() {
        List<UserLevel> userLevels = null;
        String HQL = "from UserLevel";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            userLevels = session.createQuery(HQL).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userLevels;
    }


    @Override
    public UserLevel findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        UserLevel userLevel = null;
        try {
            userLevel = session.get(UserLevel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userLevel;
    }

    @Override
    public UserLevel findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        UserLevel userLevel = null;
        try {
            Criteria criteria = session.createCriteria(UserLevel.class);
            userLevel = (UserLevel) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userLevel;
    }

    @Override
    public boolean insertUserLevel(UserLevel userLevel) {
        factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            userLevel.setCreateDate(new Date(new java.util.Date().getTime()));
            session.save(userLevel);
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
    public boolean updateUserLevel(UserLevel userLevel) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        boolean status = false;
        try {
            session.update(userLevel);
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
    public boolean disableUserLevel(int id) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            UserLevel store = session.get(UserLevel.class, id);
            store.setDelete(true);
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
        List<UserLevel> data = null;
        int count = 0;
        try {
            //get paginate
            Criteria criteria = session.createCriteria(UserLevel.class);
            criteria.setMaxResults(10 * page + 10);
            criteria.setFirstResult(10 * page);
            if (option == 1)
                criteria.add(Restrictions.eq("isDelete", false));
            else if (option == 2)
                criteria.add(Restrictions.eq("isDelete", true));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            data = criteria.list();

            //count
            criteria = session.createCriteria(UserLevel.class);
            if (option == 1)
                criteria.add(Restrictions.eq("isDelete", false));
            else if (option == 2)
                criteria.add(Restrictions.eq("isDelete", true));
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
