package com.webproject.dao.impl;

import com.webproject.dao.IUsersDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUsersDAO {

    @Override
    public User findById(int id) {
        User user = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            user = session.get(User.class, id);
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
    public List<User> getStatistic(String option, LocalDate date) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 0 nam, 1 thang, 2 7 ngay truoc, 3 ngay
        switch (option) {
            case "0": {
                LocalDate fromDate = LocalDate.parse(date.getYear() + "-01-01" + " 00:00:00");
                LocalDate toDate = LocalDate.parse(date.getYear() + "-12-31" + " 23:59:59");
                cr.add(Restrictions.between("createDate", fromDate, toDate));
            }
            case "1": {
                LocalDate fromDate = LocalDate.parse(date.getYear() + "-" + date.getMonth() + "-01" + " 00:00:00");
                LocalDate toDate = LocalDate.parse((date.getYear() + "-" + date.getMonth() + 1 + "-01" + " 00:00:00"));
                cr.add(Restrictions.between("createDate", fromDate, toDate));
            }
            case "2": {
                cr.add(Restrictions.between("createDate", date.minusDays(7), date));
            }
            case "3": {
                cr.add(Restrictions.between("createDate", date.minusDays(1), date));
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
}
