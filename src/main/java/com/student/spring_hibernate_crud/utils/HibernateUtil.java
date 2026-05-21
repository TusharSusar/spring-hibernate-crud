package com.student.spring_hibernate_crud.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        if (sessionFactory == null){
            try {
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                System.out.println("Session Factory created Successfully...");
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
