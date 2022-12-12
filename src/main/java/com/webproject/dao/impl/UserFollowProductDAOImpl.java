package com.webproject.dao.impl;

import com.webproject.dao.IUserFollowProductDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.UserFollowProduct;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserFollowProductDAOImpl implements IUserFollowProductDAO {
    @Override
    public List<UserFollowProduct> findAll() {
        List<UserFollowProduct> data = null;
        String HQL = "from UserFollowProduct";
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
    public UserFollowProduct findById(int id) {
        UserFollowProduct data = null;
        //session.get(User.class, id);
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            data = session.get(UserFollowProduct.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return data;
    }

    @Override
    public UserFollowProduct checkExists(int user, int product) {
        List<UserFollowProduct> data = null;
        String HQL = "from UserFollowProduct where userId =:userid and productId=:productid";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            data = session.createQuery(HQL).setParameter("userid", user).setParameter("productid", product).list();
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
    public boolean insertUserFollowProduct(UserFollowProduct UserFollowProduct) {
        //insert new user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            //start a transaction
            tx = session.beginTransaction();
            session.save(UserFollowProduct);
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
    public boolean updateUserFollowProduct(UserFollowProduct UserFollowProduct) {
        //update user and return status for check
        boolean status = false;
        Transaction tx = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            //start a transaction
            tx = session.beginTransaction();
            session.update(UserFollowProduct);
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
