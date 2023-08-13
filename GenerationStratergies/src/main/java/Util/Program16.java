package Util;

import Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Program16 {
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
        Product p1=ses.load(Product.class,id);
        System.out.println("Data Is :");
        System.out.println(p1.getpId()+"\t"+p1.getpName()+"\t"+p1.getpPrice());

        tx= ses.beginTransaction();
        tx.commit();
        ses.close();
    }
}
