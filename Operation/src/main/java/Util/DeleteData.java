package Util;

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

//        cfg = new Configuration().configure().addAnnotatedClass(Cust.class).addAnnotatedClass(Pro.class);
//        factory = cfg.buildSessionFactory();
//        ses = factory.openSession();
//
//        Cust c1=ses.load(Cust.class,3);
//
//        tx=ses.beginTransaction();
//        ses.delete(c1);
//        tx.commit();
       // ses.close();
        System.out.println("Data Deleted");
    }
}
