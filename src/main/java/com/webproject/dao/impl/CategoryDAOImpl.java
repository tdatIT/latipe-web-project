package com.webproject.dao.impl;

import com.webproject.dao.ICategoryDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {

    private SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public List<Category> findAll() {
        String HQL = "from Category";
        List<Category> categories = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        categories = session.createQuery(HQL).list();
        tx.commit();
        return categories;
    }

    @Override
    public List<Category> findByParentId(int id) {
        String HQL = "from Category where parentCategoryId=:parentId";
        List<Category> categories = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        categories = session.createQuery(HQL).setParameter("parentId", id).list();
        tx.commit();
        return categories;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        category = session.get(Category.class, id);
        tx.commit();
        return category;
    }

    @Override
    public Category findByName(String name) {
        Category category = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Category.class);
        category = (Category) criteria.add(Restrictions.eq("name", name)).uniqueResult();
        tx.commit();
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
