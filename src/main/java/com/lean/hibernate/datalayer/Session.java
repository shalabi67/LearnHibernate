package com.lean.hibernate.datalayer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Session {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            sessionFactory = create();
        }
        return sessionFactory;
    }

    private static SessionFactory create() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}
