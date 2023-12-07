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
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer1 c1= new Customer1("Neha");
        Product1 p1=new Product1("TV",c1);
        Product1 p2=new Product1("iPhone",c1);

        c1.addData(p1);
        c1.addData(p2);

        Customer1 c2= new Customer1("Ayush");
        Product1 p3=new Product1("Mobile",c2);
        Product1 p4=new Product1("Freeze",c2);

        c2.addData(p3);
        c2.addData(p4);

        tx=ses.beginTransaction();
        ses.save(c1);
        ses.save(c2);
        tx.commit();
        ses.close();
        System.out.println("Data Added");
    }
}
