package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DisplayDataEndUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        System.out.println("Enter Book Id Do You Want to Display :");
        int id=sc.nextInt();
        Book b = ses.load(Book.class, id);
        System.out.println(b.getBookId() + "\t" + b.getBookName() + "\t" + b.getBookPrice());

        tx = ses.beginTransaction();
        tx.commit();
        ses.close();
    }
}