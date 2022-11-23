package com.webproject.dao.impl;

import com.webproject.dao.IStoreDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.*;
import com.webproject.model.Store;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;

import com.webproject.model.*;
import com.webproject.model.Store;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
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
        Session session = HibernateUtils.getSessionFactory().openSession();
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
        DateTimeFormatter df =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");        // 0 nam, 1 thang, 2 7 ngay truoc, 3 ngay
        switch (option) {
            case "0": {
                Date fromDate = Date.from(LocalDate.parse(date.getYear() + "-01-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date toDate = Date.from(LocalDate.parse(date.getYear() + 1 + "-01-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                cr.add(Restrictions.between("createDate", fromDate, toDate));
                break;
            }
            case "1": {
                Date fromDate = Date.from(LocalDate.parse(date.getYear() + "-" + date.getMonth().getValue() + "-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date toDate = Date.from(LocalDate.parse((date.getYear() + "-" + (date.getMonth().getValue() + 1) + "-01")).atStartOfDay(ZoneId.systemDefault()).toInstant());
                cr.add(Restrictions.between("createDate", fromDate, toDate));
                break;
            }
            case "2": {
                cr.add(Restrictions.between("createDate", Date.from(date.minusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())));
                break;
            }
            case "3": {
                cr.add(Restrictions.between("createDate", Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(date.minusDays(-1).atStartOfDay(ZoneId.systemDefault()).toInstant())));
                break;
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

    @Override
    public HashMap<Integer, Object> paginate(String search, int page, int option) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Store> data = null;
        int count = 0;
        try {
            //get paginate
            Criteria criteria = session.createCriteria(Store.class);
            criteria.setMaxResults(10 * page + 10);
            criteria.setFirstResult(10 * page);
            if (option == 1)
                criteria.add(Restrictions.eq("isActive", true));
            else if (option == 2)
                criteria.add(Restrictions.eq("isActive", false));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            data = criteria.list();

            //count
            criteria = session.createCriteria(Store.class);
            if (option == 1)
                criteria.add(Restrictions.eq("isActive", true));
            else if (option == 2)
                criteria.add(Restrictions.eq("isActive", false));
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
    @Override
    public boolean setStatus(int id, boolean status) {
        Transaction tx = null;
        boolean status1 = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            Store store = session.get(Store.class, id);
            tx = session.beginTransaction();
            store.setActive(status);
            session.update(store);
            tx.commit();
            status1 = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status1;
    }
}
