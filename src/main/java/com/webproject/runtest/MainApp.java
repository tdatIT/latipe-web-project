package com.webproject.runtest;

import com.webproject.dao.IOrderDAO;
import com.webproject.dao.impl.OrderDAOImpl;

import java.sql.Date;

public class MainApp {
    public static void main(String[] args) {
        //Create new session hibernate
        IOrderDAO dao = new OrderDAOImpl();
        dao.totalProductInMonth(1,new Date(new java.util.Date().getTime()));

    }
}
