package com.webproject.dao.impl;

import com.webproject.dao.IProductDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
            Hibernate.initialize(product.getReviewsByProductId());
            Hibernate.initialize(product.getProductImgsByProductId());
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
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");        // 0 nam, 1 thang, 2 7 ngay truoc, 3 ngay
        switch (option) {
            case "0": {
                Date fromDate = Date.from(LocalDate.parse(date.getYear() + "-01-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date toDate = Date.from(LocalDate.parse(date.getYear() + 1 + "-01-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                cr.add(Restrictions.between("createDate", fromDate, toDate));
                break;
            }
            case "1": {
                YearMonth yearMonthObject = YearMonth.of(date.getYear(),  date.getMonth().getValue());
                int daysInMonth = yearMonthObject.lengthOfMonth();
                Date fromDate = Date.from(LocalDate.parse(date.getYear() + "-" + date.getMonth().getValue() + "-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date toDate = Date.from(LocalDate.parse((date.getYear() + "-" + (date.getMonth().getValue()) + "-" + daysInMonth)).atStartOfDay(ZoneId.systemDefault()).toInstant());
                cr.add(Restrictions.between("createDate", fromDate, toDate));
                break;
            }
            case "2": {
                cr.add(Restrictions.between("createDate", Date.from(date.minusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())));
                break;
            }
            case "3": {
                cr.add(Restrictions.between("createDate", Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(date.minusDays(-1).atStartOfDay(ZoneId.systemDefault()).toInstant())));
                break;
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

    @Override
    public boolean setStatus(int id, boolean status) {
        Transaction tx = null;
        boolean status1 = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            Product product = session.get(Product.class, id);
            tx = session.beginTransaction();
            product.setActive(status);
            session.update(product);
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
    public HashMap<Integer, Object> paginate(String search, int page, int option) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Product> data = null;
        int count = 0;
        try {
            //get paginate
            Criteria criteria = session.createCriteria(Product.class);
            criteria.setMaxResults(10 * page + 10);
            criteria.setFirstResult(10 * page);
            if (option == 1)
                criteria.add(Restrictions.eq("isActive", true));
            else if (option == 2)
                criteria.add(Restrictions.eq("isActive", false));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            data = criteria.list();

            //count
            criteria = session.createCriteria(Product.class);
            if (option == 1)
                criteria.add(Restrictions.eq("isActive", true));
            else if (option == 2)
                criteria.add(Restrictions.eq("isActive", false));
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

    public List<Product> find6FlashSale() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        String HQL = "from Product p order by p.price-p.promotionalPrice desc";
        List<Product> products = new ArrayList<>();

        try {
            products = session.createQuery(HQL)
                    .setFirstResult(0)
                    .setMaxResults(6)
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public List<Product> newProductList() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        String HQL = "from Product p order by p.createDate desc";
        List<Product> products = new ArrayList<>();

        try {
            products = session.createQuery(HQL)
                    .setFirstResult(0)
                    .setMaxResults(6)
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public List<Product> findHotProduct() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        String HQL = "from Product p order by p.sold desc";
        List<Product> products = new ArrayList<>();

        try {
            products = session.createQuery(HQL)
                    .setFirstResult(0)
                    .setMaxResults(6)
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    public HashMap<Integer, Object> paginateWeb(String search, int page, int cate, int minPrice, int maxPrice, int status) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Product> data = null;
        int count = 0;
        try {
            //get paginate
            Criteria criteria = session.createCriteria(Product.class);
            criteria.setMaxResults(12 * page + 12);
            criteria.setFirstResult(12 * page);
            // filter
            criteria.add(Restrictions.eq("isActive", true));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            if (cate != -1) {
                criteria.add(Restrictions.eq("categoryId", cate));
            }
            if (minPrice != -1) {
                criteria.add(Restrictions.ge("price", Double.valueOf(minPrice)));
                criteria.add(Restrictions.lt("price", Double.valueOf(maxPrice)));
            }
            if (status != -1) {
                switch (status) {
                    case 1: {
                        criteria.addOrder(Order.asc("price"));
                        break;
                    }
                    case 2: {
                        criteria.addOrder(Order.desc("price"));
                        break;
                    }
                }
            }
            data = criteria.list();

            //---------------count---------------
            // filter
            criteria.add(Restrictions.eq("isActive", true));
            criteria.add(Restrictions.like("name", search, MatchMode.ANYWHERE));
            if (cate != -1) {
                criteria.add(Restrictions.eq("categoryId", cate));
            }
            if (minPrice != -1) {
                criteria.add(Restrictions.ge("price", Double.valueOf(minPrice)));
                criteria.add(Restrictions.lt("price", Double.valueOf(maxPrice)));
            }
            if (status != -1) {
                switch (status) {
                    case 1: {
                        criteria.addOrder(Order.asc("price"));
                        break;
                    }
                    case 2: {
                        criteria.addOrder(Order.desc("price"));
                        break;
                    }
                }
            }
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

    @Override
    public List<Product> findProductForYou(int userId) {
        String HQL = (userId == 0) ?
                "select i.productByProductId " +
                        "from OrderItems i " +
                        "group by i.productByProductId " +
                        "order by count(i.productByProductId) desc"
                :
                "select item.productByProductId from OrderItems item " +
                        " where (item.productByProductId.isActive = true) and (item.order.userId = :id) " +
                        " order by item.order.createDate desc ";
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Product> products = new ArrayList<>();
        try {

            products = (userId != 0) ?
                    session.createQuery(HQL)
                            .setFirstResult(0)
                            .setMaxResults(8)
                            .setParameter("id", userId)
                            .list()
                    :
                    session.createQuery(HQL)
                            .setFirstResult(0)
                            .setMaxResults(8)
                            .list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }
}
