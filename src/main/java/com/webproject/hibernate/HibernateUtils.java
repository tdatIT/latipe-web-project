package com.webproject.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static SessionFactory getSessionFactory() {
        SessionFactory factory = null;
        try {
            Configuration configuration = new Configuration();
            factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }
}
