package Util;

import Model.Customer2;
import Model.Product2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Product2 p1=ses.load(Product2.class,1001);
        p1.setpPrice(34999.99);

        Customer2 c1=ses.load(Customer2.class,1);
        c1.setcName("Shubham");

        tx= ses.beginTransaction();
        ses.update(p1);
        ses.update(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
