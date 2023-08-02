package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteDataEndUser
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        factory=new Configuration().configure().buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        Book b=ses.load(Book.class,id);

        tx=ses.beginTransaction();
        ses.delete(b);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}