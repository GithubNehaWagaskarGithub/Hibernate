package Util;

import Model.Customer3;
import Model.Product3;
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

        cfg=new Configuration().configure().addAnnotatedClass(Product3.class).addAnnotatedClass(Customer3.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //Customer3 c1=ses.load(Customer3.class,101);

        Product3 p1=ses.load(Product3.class,4);

        tx=ses.beginTransaction();
        //ses.delete(c1);
        ses.delete(p1);
        tx.commit();
        ses.close();
        System.out.println("Data deleted");
    }
}
