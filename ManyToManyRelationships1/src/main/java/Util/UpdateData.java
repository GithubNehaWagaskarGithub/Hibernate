package Util;

import Model.Customer3;
import Model.Product3;
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

        cfg=new Configuration().configure().addAnnotatedClass(Product3.class).addAnnotatedClass(Customer3.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer3 c1=ses.load(Customer3.class,100);
        c1.setcName("Aaku");

        Product3 p1=ses.load(Product3.class,1);
        p1.setpPrice(15000);

        tx=ses.beginTransaction();
        ses.update(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
