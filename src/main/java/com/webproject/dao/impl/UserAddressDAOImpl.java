package com.webproject.dao.impl;

import com.webproject.dao.IUserAddressDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.User;
import com.webproject.model.UserAddress;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class UserAddressDAOImpl implements IUserAddressDAO {

    @Override
    public List<UserAddress> findAll() {
        List<UserAddress> useraddress = null;
        String HQL = "from UserAddress";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            useraddress = session.createQuery(HQL).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return useraddress;
    }


    @Override
    public UserAddress findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        UserAddress useraddress = null;
        try {
            useraddress = session.get(UserAddress.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return useraddress;
    }

    @Override
    public UserAddress findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        UserAddress useraddress = null;
        try {
            Criteria criteria = session.createCriteria(UserAddress.class);
            useraddress = (UserAddress) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return useraddress;
    }

    @Override
    public boolean insertUserAddress(UserAddress useraddress) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {

            session.save(useraddress);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateUserAddress(UserAddress useraddress) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
//
//           int count = query.executeUpdate();
            session.update(useraddress);
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
    public boolean deleteUserAddress(int id) {
        boolean status = false;
        Transaction transaction = null;
        UserAddress address = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {

            address = session.get(UserAddress.class, id);
            session.delete(address);
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
        List<UserAddress> data = null;
        int count = 0;
        try {
            //get paginate
            Criteria criteria = session.createCriteria(UserAddress.class);
            // 1 trang co 10 record
            // trang 2 lay max 20 record bo ua 10 record dau tien
            criteria.setMaxResults(10 * page + 10);
            criteria.setFirstResult(10 * page);
            if (option == 1)
                criteria.add(Restrictions.eq("isDeleted", false));
            else if (option == 2)
                criteria.add(Restrictions.eq("isDeleted", true));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE)); // ==  name like N'data'
            data = criteria.list();

            //count
            criteria = session.createCriteria(UserAddress.class);
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
}
