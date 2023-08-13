package Util;

import Model.Customer;
import Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Program12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Id Do you want to Delete :");
        int id=sc.nextInt();
        Product p1=ses.load(Product.class,id);

        tx= ses.beginTransaction();
        ses.delete(p1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
