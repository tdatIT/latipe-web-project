package com.webproject.dao.impl;

import com.webproject.dao.IUserFollowStoreDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Product;
import com.webproject.model.UserFollowStore;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserFollowStoreDAOImpl implements IUserFollowStoreDAO {
    @Override
    public List<UserFollowStore> findAll() {
        List<UserFollowStore> data = null;
        String HQL = "from UserFollowStore";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            data = session.createQuery(HQL).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return data;
    }

    @Override
    public UserFollowStore findById(int id) {
        UserFollowStore data = null;
        //session.get(User.class, id);
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            data = session.get(UserFollowStore.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return data;
    }

    @Override
    public UserFollowStore checkExists(int user, int store) {
        List<UserFollowStore> data = null;
        String HQL = "from UserFollowStore where userId =:userid and storeId=:storeid";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            data = session.createQuery(HQL).setParameter("userid", user).setParameter("storeid", store).list();
            if (data.size() >0)
                return data.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;

    }

    //insert new user and return status for check
    @Override
    public boolean insertUserFollowStore(UserFollowStore UserFollowStore) {
        //insert new user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            //start a transaction
            tx = session.beginTransaction();
            session.save(UserFollowStore);
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
    public boolean updateUserFollowStore(UserFollowStore UserFollowStore) {
        //update user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            //start a transaction
            tx = session.beginTransaction();
            session.update(UserFollowStore);
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
    public boolean delete(int id) {
        return false;
    }
}
