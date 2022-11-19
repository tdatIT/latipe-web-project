package com.webproject.dao.impl;

import com.webproject.dao.IProductDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Product;
import com.webproject.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {

    @Override
    public List<Product> fullTextSearch(String keyword) {
        List<Product> products = null;
        String HQL = "from Product where name like :keyword";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            products = session.createQuery(HQL)
                    .setParameter("keyword", "%" + keyword + "%").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = null;
        String HQL = "from Product";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            products = session.createQuery(HQL).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public List<Product> findByCategoryId(int id) {
        List<Product> products = null;
        String HQL = "from Product where categoryId = :id";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            products = session.createQuery(HQL).setParameter("id", id).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public List<Product> findProductByStoreId(int id) {
        List<Product> products = null;
        String HQL = "from Product where storeId = :id";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            products = session.createQuery(HQL).setParameter("id", id).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            product = session.get(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }

    @Override
    public Product findByName(String name) {
        String HQL = "from Product where name = :name";
        Product product = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            product = (Product) session.createQuery(HQL)
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }

    @Override
    public int insertProduct(Product product) {
        int id = 0;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(product);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(product);
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
    public boolean disableProduct(int id) {
        boolean status = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setActive(false);
            product.setQuantity(0);
            product.setPrice(0);
            product.setPromotionalPrice(0D);
            product.setName(product.getName() + " [DELETED]");
            session.update(product);
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
    public List<Product> getStatistic(String option, LocalDate date) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Product.class);
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
        List<Product> results = null;
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
