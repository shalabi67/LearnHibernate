package com.lean.hibernate;

import com.lean.hibernate.entity.Users;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static com.lean.hibernate.datalayer.Session.getSessionFactory;

public class Application {
    public static void main(String[] args) {
        System.out.println("hello");

        SessionFactory factory = getSessionFactory();
        System.out.println("Session factory object created : " + factory);
        Session session = factory.openSession();
        try {
            Users user = new Users();
            user.setId(1);
            user.setLastName("shalabi");
            user.setFirstName("mohammad");

            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
