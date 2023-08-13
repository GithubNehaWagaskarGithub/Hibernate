package Util;

import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Program1 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer c1=new Customer("Aishu","Kesnand");

        tx= ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
