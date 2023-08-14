package Util;

import Model.Customer1;
import Model.Product1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer1.class).addAnnotatedClass(Product1.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer1 c1=new Customer1("Pooja","Koregaon");
        Product1 p1=new Product1("Mobile",64999.99,c1);
        Product1 p2=new Product1("Laptop",40999.99,c1);

        tx= ses.beginTransaction();
        ses.save(p1);
        ses.save(p2);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
