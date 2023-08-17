package Util;

import Model.Customer2;
import Model.Product2;
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

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer2 c1=new Customer2("Neha");
        Product2 p1=new Product2("Mobile",45999.99);
        Product2 p2=new Product2("TV",66999.99);

        c1.addData(p1);
        c1.addData(p2);

        tx=ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
