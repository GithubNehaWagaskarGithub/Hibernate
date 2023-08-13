package Util;

import Model.Customer;
import Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Program14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Name :");
        String name=sc.next();
        System.out.println("Enter a Price :");
        double price=sc.nextDouble();

        Product p1=ses.load(Product.class,id);
        p1.setpName(name);
        p1.setpPrice(price);

        tx= ses.beginTransaction();
        ses.update(p1);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
