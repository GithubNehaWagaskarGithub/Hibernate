package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateDataEndUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Update a Name :");
        String name=sc.next();
        System.out.println("Update a Price :");
        double price=sc.nextDouble();

        Book b=ses.load(Book.class,id);
        b.setBookName(name);
        b.setBookPrice(price);

        tx=ses.beginTransaction();
        ses.update(b);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
