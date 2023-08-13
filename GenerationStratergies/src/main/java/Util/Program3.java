package Util;

import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;


public class Program3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter Customer Name :");
        String name=sc.next();
        System.out.println("Enter Customer Address :");
        String add=sc.next();

        Customer c1=new Customer(name,add);

        tx=ses.beginTransaction();
        ses.save(c1);
        tx.commit();;
        ses.close();
        System.out.println("Data Inserted");
    }
}
