package com.webproject.dao.impl;

import com.webproject.dao.ICommissionDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Commission;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CommissionDAOImpl implements ICommissionDAO {


    @Override
    public List<Commission> findAll() {
        List<Commission> categories = null;
        String HQL = "from Commission";
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
    public Commission findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Commission category = null;
        try {
            category = session.get(Commission.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public Commission findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Commission category = null;
        try {
            Criteria criteria = session.createCriteria(Commission.class);
            category = (Commission) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public boolean insertCommission(Commission category) {
        return false;
    }

    @Override
    public boolean updateCommission(Commission category) {
        return false;
    }

    @Override
    public boolean disableCommission(int id) {
        return false;
    }
}
