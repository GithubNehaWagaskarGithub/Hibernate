package Util;

import Model.Customer;
import Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Program11 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Product p1=ses.load(Product.class,131);

        tx= ses.beginTransaction();
        ses.delete(p1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
