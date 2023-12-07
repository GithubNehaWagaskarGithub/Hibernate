package Util;


import Model.Customer3;
import Model.Product3;
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

        cfg=new Configuration().configure().addAnnotatedClass(Product3.class).addAnnotatedClass(Customer3.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer3 c1=new Customer3("Neha");
        Customer3 c2=new Customer3("Ayush");

        Product3 p1=new Product3("TV",34000);
        Product3 p2=new Product3("Camera",7600);
        Product3 p3=new Product3("Freeze",56000);
        Product3 p4=new Product3("Fan",5500);
        c1.addData(p1);
        c1.addData(p2);
        c2.addData(p3);
        c2.addData(p4);

        //p1.addData(c2);

        tx=ses.beginTransaction();
        ses.save(c1);
        ses.save(c2);
        ses.save(p1);
        tx.commit();
        ses.close();
        System.out.println("Data Added");
    }
}
