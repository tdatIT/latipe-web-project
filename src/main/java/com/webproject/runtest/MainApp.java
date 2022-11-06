package com.webproject.runtest;

import com.webproject.hibernate.HibernateUtils;
import com.webproject.model.Role;
import com.webproject.model.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        //Create new session hibernate
        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Role role = session.get(Role.class,1);

        role.setName("ADMIN");
        session.update(role);
        tx.commit();
        System.out.println(role.getName());
        session.close();

    }
}
