package com.webproject.runtest;

import com.webproject.dao.impl.ProductDAOImpl;
import com.webproject.model.Product;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        //Create new session hibernate
//        SessionFactory factory = HibernateUtils.getSessionFactory();
//
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//        Role role = session.get(Role.class,1);
//
//        role.setName("ADMIN");
//        session.update(role);
//        tx.commit();
//        System.out.println(role.getName());
//        session.close();
        ProductDAOImpl dao = new ProductDAOImpl();
        List<Product> productList = dao.findProductForYou(0);
        //System.out.println("Present Project Directory : " + System.getProperty("user.dir") + "\\src\\main\\webapp\\view\\admin");
        System.out.println(productList.size());
    }
}
