package com.webproject.dao.impl;

import com.webproject.dao.ICategoryDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {


    @Override
    public List<Category> findAll() {
        List<Category> categories = null;
        String HQL = "from Category";
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
    public List<Category> findByParentId(int id) {
        List<Category> categories = null;
        String HQL = "from Category where parentCategoryId=:parentId";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            categories = session.createQuery(HQL).setParameter("parentId", id).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Category category = null;
        try {
            category = session.get(Category.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public Category findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Category category = null;
        try {
            Criteria criteria = session.createCriteria(Category.class);
            category = (Category) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public boolean insertCategory(Category category) {
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }

    @Override
    public boolean disableCategory(int id) {
        return false;
    }
}
