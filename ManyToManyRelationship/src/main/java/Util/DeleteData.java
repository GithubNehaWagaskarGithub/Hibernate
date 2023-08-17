package Util;

import Model.Customer2;
import Model.Product2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DeleteData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Customer2 c1=ses.load(Customer2.class,2);

        tx= ses.beginTransaction();
        ses.delete(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
