package com.webproject.dao.impl;

import com.webproject.dao.IOrderDAO;
import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Orders;
import com.webproject.model.Store;
import com.webproject.model.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class OrderDAOImpl implements IOrderDAO {
    private SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public List<Orders> findAll() {
        List<Orders> orders = null;
        String HQL = "from Orders";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL).list();
        tx.commit();
        return orders;
    }

    @Override
    public List<Orders> findByUserId(int id) {
        List<Orders> orders = null;
        String HQL = "from Orders where userId = :id";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL)
                .setParameter("id", id).list();
        tx.commit();
        return orders;
    }

    @Override
    public List<Orders> findByShopId(int id) {
        List<Orders> orders = null;
        String HQL = "from Orders where storeId = :id";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            orders = session.createQuery(HQL)
                    .setParameter("id", id).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Orders findById(int id) {
        Orders orders = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            orders = session.get(Orders.class, id);
            Hibernate.initialize(orders.getItem());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public List<Orders> findByDate(Date date) {
        List<Orders> orders = null;
        String HQL = "from Orders where createDate = :date";
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        orders = session.createQuery(HQL)
                .setParameter("date", date).list();
        tx.commit();
        return orders;
    }

    @Override
    public boolean insertOrder(Orders orders) {
        boolean status = false;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(orders);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean updateOrder(Orders orders) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(orders);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;
    }

    @Override
    public boolean cancelOrder(int id) {
        boolean status = false;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Orders orders = session.get(Orders.class, id);
            orders.setStatus(0);
            session.update(orders);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return status;

    }

    @Override
    public List<Objects[]> totalOrdersFromStore5Month(int storeId, Date date) {
        List<Objects[]> orderToMonth = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            String HQL = "select month(o.createDate),count(*) from Orders o " +
                    "where ((MONTH(o.createDate)<= :_start AND MONTH(o.createDate)>=:_end) AND YEAR(o.createDate)=:year)" +
                    "AND o.storeId =:storeId  group by " +
                    "month(o.createDate) order by MONTH(o.createDate) DESC ";
            orderToMonth = session.createQuery(HQL)
                    .setParameter("storeId", storeId)
                    .setParameter("_start", date.toLocalDate().getMonthValue())
                    .setParameter("_end", date.toLocalDate().getMonthValue() - 5)
                    .setParameter("year", date.toLocalDate().getYear())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderToMonth;
    }

    @Override
    public List<Objects[]> totalAmountsFromStore5Month(int storeId, Date date) {
        List<Objects[]> orderToMonth = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            String HQL = "select month(o.createDate),sum(o.amountToStore) from Orders o " +
                    "where ((MONTH(o.createDate)<= :_start AND MONTH(o.createDate)>=:_end) AND YEAR(o.createDate)=:year)" +
                    "AND o.storeId =:storeId  group by " +
                    "month(o.createDate) order by MONTH(o.createDate) DESC ";
            orderToMonth = session.createQuery(HQL)
                    .setParameter("storeId", storeId)
                    .setParameter("_start", date.toLocalDate().getMonthValue())
                    .setParameter("_end", date.toLocalDate().getMonthValue() - 5)
                    .setParameter("year", date.toLocalDate().getYear())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderToMonth;

    }

    @Override
    public List<Objects[]> totalProductInMonth(int storeId, Date date) {
        List<Objects[]> orderToMonth = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            String HQL = "select i.productByProductId.name,count(*) " +
                    "from OrderItems i inner join i.order " +
                    "where ((month (i.order.createDate)<= :_start and month(i.order.createDate)>=:_end) " +
                    "and year(i.order.createDate)=:year)" +
                    "and i.order.storeId=:storeId " +
                    "group by i.productId";
            orderToMonth = session.createQuery(HQL)
                    .setParameter("storeId", storeId)
                    .setParameter("_start", date.toLocalDate().getMonthValue())
                    .setParameter("_end", date.toLocalDate().getMonthValue() - 1)
                    .setParameter("year", date.toLocalDate().getYear())
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderToMonth;
    }

    @Override
    public List<Orders> getStatistic(String option, LocalDate date) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Orders.class);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 0 nam, 1 thang, 2 7 ngay truoc, 3 ngay
        switch (option) {
            case "0": {
                java.util.Date fromDate = java.util.Date.from(LocalDate.parse(date.getYear() + "-01-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.util.Date toDate = java.util.Date.from(LocalDate.parse(date.getYear() + 1 + "-01-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                cr.add(Restrictions.between("createDate", fromDate, toDate));
                break;
            }
            case "1": {
                java.util.Date fromDate = java.util.Date.from(LocalDate.parse(date.getYear() + "-" + date.getMonth().getValue() + "-01").atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.util.Date toDate = java.util.Date.from(LocalDate.parse((date.getYear() + "-" + (date.getMonth().getValue() + 1) + "-01")).atStartOfDay(ZoneId.systemDefault()).toInstant());
                cr.add(Restrictions.between("createDate", fromDate, toDate));
                break;
            }
            case "2": {
                cr.add(Restrictions.between("createDate", java.util.Date.from(date.minusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()), java.util.Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())));
                break;
            }
            case "3": {
                cr.add(Restrictions.between("createDate", java.util.Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()), java.util.Date.from(date.minusDays(-1).atStartOfDay(ZoneId.systemDefault()).toInstant())));
                break;
            }
        }
        List<Orders> results = null;
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
    public HashMap<Integer, Object> paginate(String search, int page, int status) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Orders> data = new ArrayList<Orders>();
        int count = 0;
        try {
            Query q;
            if (status != 0) {
                q = session.createQuery("from Orders o join User u ON u.userId = o.userId join Store s on s.storeId = o.storeId where o.status=:status and concat(s.name,u.firstname, u.lastname) like :search");
                q.setParameter("status", status);
            } else {
                q = session.createQuery("from Orders o join User u ON u.userId = o.userId join Store s on s.storeId = o.storeId where concat(s.name, u.firstname, u.lastname) like :search");
            }
            q.setMaxResults(10 * page + 10);
            q.setFirstResult(10 * page);
            q.setParameter("search", "%" + search + "%");
            List<Object[]> rawData = q.getResultList();
            for (Object[] t : rawData) {
                data.add((Orders) t[0]);
            }
            //count
            if (status != 0) {
                q = session.createQuery("from Orders o join User u ON u.userId = o.userId join Store s on s.storeId = o.storeId where o.status=:status and concat(s.name,u.firstname, u.lastname) like :search");
                q.setParameter("status", status);
            } else {
                q = session.createQuery("from Orders o join User u ON u.userId = o.userId join Store s on s.storeId = o.storeId where concat(s.name, u.firstname, u.lastname) like :search");
            }
            q.setParameter("search", "%" + search + "%");
            count = q.getResultList().size();
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
    public boolean setStatus(int id, int status) {
        Transaction tx = null;
        boolean status1 = false;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            Orders order = session.get(Orders.class, id);
            Store store = session.get(Store.class, order.getStoreId());
            User user = session.get(User.class, order.getUserId());
            tx = session.beginTransaction();
            // user huy
            if (status == 4) {
                if (order.getStatus() != 4 && order.getStatus() != 5 && order.getStatus() != 3) {
                    order.setStatus(4);
                    user.seteWallet(user.geteWallet() + order.getAmountToStore());
                    user.setPoint(user.getPoint() - 1);
                } else {
                    throw new Exception("Not Permission");
                }
            }
            // shop huy
            else if (status == 5) {
                if (order.getStatus() != 4 && order.getStatus() != 5 && order.getStatus() != 3) {
                    order.setStatus(4);
                    user.seteWallet(user.geteWallet() + order.getAmountToStore());
                    store.setPoint(store.getPoint() - 1);
                } else {
                    throw new Exception("Not Permission");
                }
            }
            // thanh cong
            else if (status == 3) {
                if (order.getStatus() != 4 && order.getStatus() != 5 && order.getStatus() != 3) {
                    order.setStatus(3);
                    store.seteWallet(store.geteWallet() + order.getAmountToStore());
                    store.setPoint(store.getPoint() + 1);
                } else {
                    throw new Exception("Not Permission");
                }
            } else if (status == 2) {
                order.setStatus(2);
            } else {
                throw new Exception("Not Permission");
            }
            session.update(store);
            session.update(order);
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
