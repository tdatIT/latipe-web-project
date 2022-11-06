package com.webproject.dao.impl;

import com.webproject.dao.IProductDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAOImpl implements IProductDAO {
    private SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public List<Product> fullTextSearch(String keyword) {
        List<Product> products = null;
        String HQL = "from Product where name like :keyword";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        products = session.createQuery(HQL)
                .setParameter("keyword", "%" + keyword + "%").list();
        tx.commit();
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = null;
        String HQL = "from Product";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        products = session.createQuery(HQL).list();
        tx.commit();
        return products;
    }

    @Override
    public List<Product> findByCategoryId(int id) {
        List<Product> products = null;
        String HQL = "from Product where categoryId = :id";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        products = session.createQuery(HQL).setParameter("id", id).list();
        tx.commit();
        return products;
    }

    @Override
    public List<Product> findProductByStoreId(int id) {
        List<Product> products = null;
        String HQL = "from Product where storeId = :id";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        products = session.createQuery(HQL).setParameter("id", id).list();
        tx.commit();
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Session session = factory.getCurrentSession();
        product = session.get(Product.class, id);
        return product;
    }

    @Override
    public Product findByName(String name) {
        String HQL = "from Product where name = :name";
        Product product = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        product = (Product) session.createQuery(HQL)
                .setParameter("name", name)
                .uniqueResult();
        tx.commit();
        return product;
    }

    @Override
    public boolean insertProduct(Product product) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(product);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean disableProduct(int id) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setActive(false);
            session.update(product);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

}
