package com.webproject.dao.impl;

import com.webproject.dao.ICommissionDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Commission;
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

public class CommissionDAOImpl implements ICommissionDAO {
    private SessionFactory factory;

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
        Commission commission = null;
        try {
            commission = session.get(Commission.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return commission;
    }

    @Override
    public Commission findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Commission commission = null;
        try {
            Criteria criteria = session.createCriteria(Commission.class);
            commission = (Commission) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return commission;
    }

    @Override
    public boolean insertCommission(Commission commission) {
        factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            commission.setCreateDate(new Date(new java.util.Date().getTime()));
            session.save(commission);
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
    public boolean updateCommission(Commission commission) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(commission);
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
    public boolean disableCommission(int id) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Commission store = session.get(Commission.class, id);
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
        List<Commission> data = null;
        int count = 0;
        try {
            //get paginate
            Criteria criteria = session.createCriteria(Commission.class);
            criteria.setMaxResults(10 * page + 10);
            criteria.setFirstResult(10 * page);
            if (option == 1)
                criteria.add(Restrictions.eq("isDeleted", false));
            else if (option == 2)
                criteria.add(Restrictions.eq("isDeleted", true));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            data = criteria.list();

            //count
            criteria = session.createCriteria(Commission.class);
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
