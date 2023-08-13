package Util;

import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Program9 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Data Is :");
        Customer c1=ses.load(Customer.class,1);
        System.out.println(c1.getcId()+"\t"+c1.getcName()+"\t"+c1.getsAdd());

        tx= ses.beginTransaction();
        tx.commit();
        ses.close();

    }
}
