package Util;

import Model.Customer;
import Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Program15 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Data Is :");
        Product p1=ses.load(Product.class,131);
        System.out.println(p1.getpId()+"\t"+p1.getpName()+"\t"+p1.getpPrice());

        tx= ses.beginTransaction();
        tx.commit();
        ses.close();
    }
}
