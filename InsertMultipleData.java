package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertMultipleData
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter Num Do you Want to Insert Books :");
        int num=sc.nextInt();

        for(int i=0;i<num;i++)
        {
            System.out.println("Enter Id :");
            int id=sc.nextInt();
            System.out.println("Enter Name :");
            String name=sc.next();
            System.out.println("Enter Price :");
            double price=sc.nextDouble();
            //Book b1=new Book(id,name,price);
            Book b1=new Book();
            b1.setBookId(id);
            b1.setBookName(name);
            b1.setBookPrice(price);

            tx=ses.beginTransaction();
            ses.save(b1);
            tx.commit();

            System.out.println("Data Inserted Successfully");//double dd=sc.nextInt(); is also correct
        }
        ses.close();
    }
}
