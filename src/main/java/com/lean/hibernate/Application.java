package com.lean.hibernate;

import com.lean.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static com.lean.hibernate.datalayer.Session.getSessionFactory;

public class Application {
    public static void main(String[] args) {
        System.out.println("hello");

        SessionFactory sessionFactory = getSessionFactory();
        System.out.println("Session factory object created : " + sessionFactory);
        Session session = sessionFactory.openSession();
        try {

            /*
            User user = new User();
            user.setId(2);
            user.setLastName("shalabi");
            user.setFirstName("ali");

            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            */


            session.beginTransaction();
            User user1 = session.get(User.class, 1);
            System.out.println(user1.getLastName());

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
