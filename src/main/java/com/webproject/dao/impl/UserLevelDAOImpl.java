package com.webproject.dao.impl;

import com.webproject.dao.IUserLevelDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.UserLevel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserLevelDAOImpl implements IUserLevelDAO {
    @Override
    public List<UserLevel> findAll() {
        List<UserLevel> categories = null;
        String HQL = "from UserLevel";
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
    public UserLevel findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        UserLevel category = null;
        try {
            category = session.get(UserLevel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public UserLevel findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        UserLevel category = null;
        try {
            Criteria criteria = session.createCriteria(UserLevel.class);
            category = (UserLevel) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public boolean insertUserLevel(UserLevel category) {
        return false;
    }

    @Override
    public boolean updateUserLevel(UserLevel category) {
        return false;
    }

    @Override
    public boolean disableUserLevel(int id) {
        return false;
    }
}
