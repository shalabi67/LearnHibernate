package com.lean.hibernate;

import com.lean.hibernate.entity.User;
import com.lean.hibernate.entity.UserHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

import static com.lean.hibernate.datalayer.Session.getSessionFactory;

public class Application {
    public static void main(String[] args) {
        System.out.println("hello");

        SessionFactory sessionFactory = getSessionFactory();
        System.out.println("Session factory object created : " + sessionFactory);
        Session session = sessionFactory.openSession();
        try {

            int id = 6;

            /*
            User user = new User();
            user.setId(id);
            user.setLastName("shalabi");
            user.setFirstName("ali");
            user.getAddress().setStreet("löwen");
            user.getAddress().setCity("berlin");

            UserHistory userHistory1 = new UserHistory(new Date(), "user hostory 1");
            UserHistory userHistory2 = new UserHistory(new Date(), "user hostory 2");

            user.addHistory(userHistory1);
            user.addHistory(userHistory2);

            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            */

            session.beginTransaction();
            User user = session.get(User.class, 1);

            UserHistory userHistory1 = new UserHistory(new Date(), "user hostory 1");
            UserHistory userHistory2 = new UserHistory(new Date(), "user hostory 2");

            user.addHistory(userHistory1);
            user.addHistory(userHistory2);

            session.save(user);

            session.getTransaction().commit();


            session.beginTransaction();
            User user1 = session.get(User.class, 1);
            System.out.println(user1.getLastName());

            UserHistory userHistory = session.get(UserHistory.class, 1);
            for(UserHistory history : user1.getUserHistories()) {
                System.out.println(history.getEntry());
            }

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
