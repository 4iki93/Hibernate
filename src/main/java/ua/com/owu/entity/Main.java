package ua.com.owu.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        //session.getTransaction().begin();
        //session.save(new User ("Vova","Puatov"));
        //System.out.println(session.find(User.class, 1));  //вивести юзера



       /* List<Product> products = new ArrayList<>();
        products.add(new Product("milk","base"));
        products.add(new Product("bread","base"));
        products.add(new Product("water","base"));

        User user = session.find(User.class, 2);
        user.setProducts(products);
        session.save(user);*/


        Query<User> query = session.createQuery("from User u", User.class);// все з юзера
        //List<User> resultList = query.getResultList();
        System.out.println(query.getResultList());


        User user = session.find(User.class, 1);
        List<Product> resultList = session.createQuery("from Product p where p.id<=2",Product.class).getResultList();

        for (Product product : resultList) {
            product.setUser(user);
            session.save(product);
        }




        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}

