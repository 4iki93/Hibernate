package ua.com.owu.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(new User ("Vasya","Peukin"));
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}

