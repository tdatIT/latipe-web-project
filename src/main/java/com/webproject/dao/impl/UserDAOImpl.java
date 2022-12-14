package com.webproject.dao.impl;

import com.webproject.dao.IUsersDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements IUsersDAO {

    @Override
    public User findById(int id) {
        User user = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            user = session.get(User.class, id);
            Hibernate.initialize(user.getUserAddressesByUserId());
            Hibernate.initialize(user.getCartsByUserId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public boolean validate(String email, String password) {
        //Using HQL
        Session session = HibernateUtils.getSessionFactory().openSession();
        String HQL = "from User where email = :email and hashedPassword = :password";
        List<User> users = new ArrayList<>();
        boolean status = false;
        try {
            users = session.createQuery(HQL)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .list();
            if (users.size() > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            users = session.createQuery("SELECT a FROM User a", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        //Using Criteria
        User us = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(User.class);
            us = (User) criteria.add(Restrictions.eq("email", email))
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return us;
    }

    @Override
    public boolean insertNewUser(User user) {
        //insert new user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            //start a transaction
            tx = session.beginTransaction();
            session.save(user);
            //if success commit trans
            tx.commit();
            status = true;
        } catch (Exception e) {
            //roll back trans when insert failed
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    @Override
    public boolean updateUser(User user) {
        //update user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            //start a transaction
            tx = session.beginTransaction();
            session.update(user);
            //if success commit trans
            tx.commit();
            status = true;
        } catch (Exception e) {
            //roll back trans when insert failed
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    @Override
    public boolean disableUser(int id) {
        //update user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            //retrieve Object
            User user = session.get(User.class, id);
            //start a transaction
            tx = session.beginTransaction();
            user.setDeleted(true);
            session.update(user);
            //if success commit trans
            tx.commit();
            status = true;
        } catch (Exception e) {
            //roll back trans when insert failed
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    @Override
    public boolean updateRole(int id, int role_id) {
        return false;
    }
    @Override
    public List<User> findByStore(int storeId) {
        String HQL = "from User u where u.storeEmpId=:storeId";
        List<User> users = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            users = session.createQuery(HQL).setParameter("storeId", storeId)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }
    @Override
    public List<User> getStatistic(String option, LocalDate date) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 0 nam, 1 thang, 2 7 ngay truoc, 3 ngay
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
        }
        List<User> results = null;
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
    public boolean setStatus(int id, boolean status) {
        Transaction tx = null;
        boolean status1 = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            User user = session.get(User.class, id);
            tx = session.beginTransaction();
            user.setDeleted(status);
            session.update(user);
            tx.commit();
            status1 = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status1;
    }

    @Override
    public HashMap<Integer, Object> paginate(String search, int option, int page) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<User> data = null;
        int count = 0;
        try {
            //get paginate
//            Criteria criteria = session.createCriteria(User.class);
            Query q;
            if (option != 0) {
                q = session.createQuery("from User where isDeleted=:status and concat(firstname, lastname) like :search");
                q.setParameter("status", option == 1 ? false : true);
            } else {
                q = session.createQuery("from User where concat(firstname, lastname) like :search");
            }
            q.setMaxResults(10 * page + 10);
            q.setFirstResult(10 * page);
            q.setParameter("search", "%" + search + "%");
            data = q.getResultList();

            //count
            if (option != 0) {
                q = session.createQuery("from User where isDeleted=:status and concat(firstname, lastname) like :search");
                q.setParameter("status", option == 1 ? false : true);
            } else {
                q = session.createQuery("from User where concat(firstname, lastname) like :search");
            }
            q.setParameter("search", "%" + search + "%");
            count = q.getResultList().size();
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
