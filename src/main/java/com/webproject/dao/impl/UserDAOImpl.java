package com.webproject.dao.impl;

import com.webproject.dao.IUsersDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUsersDAO {
    private SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public User findById(int id) {
        User user = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        user = session.get(User.class, id);
        tx.commit();
        return user;
    }

    @Override
    public boolean validate(String email, String password) {
        //Using HQL
        String HQL = "from User where email = :email and hashedPassword = :password";
        List<User> users = new ArrayList<>();
        boolean status = false;
        try {
            Session session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            users = session.createQuery(HQL)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .list();
            tx.commit();
            if (users.size() > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public User getUserByEmail(String email) {
        //Using Criteria
        User us = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(User.class);
            us = (User) criteria.add(Restrictions.eq("email", email))
                    .uniqueResult();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        return us;
    }

    @Override
    public boolean insertNewUser(User user) {
        //insert new user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = factory.getCurrentSession();
        try {
            //start a transaction
            tx = session.beginTransaction();
            session.save(user);
            //if success commit trans
            tx.commit();
            status = true;
        } catch (Exception e) {
            //roll back trans when insert failed
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateUser(User user) {
        //update user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = factory.getCurrentSession();
        try {
            //start a transaction
            tx = session.beginTransaction();
            session.update(user);
            //if success commit trans
            tx.commit();
            status = true;
        } catch (Exception e) {
            //roll back trans when insert failed
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean disableUser(int id) {
        //update user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = factory.getCurrentSession();
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
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateRole(int id, int role_id) {
        return false;
    }
}
