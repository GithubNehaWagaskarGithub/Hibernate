package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertDataByArrayList
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        System.out.println("Enter Num Do you Want to Insert Books :");
        int num=sc.nextInt();

        ArrayList<Book> book=new ArrayList<>();
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
            book.add(b1);
        }

//        System.out.println("Do you want to display the data Yes/No :");
//        String ans=sc.next();
//        if(ans.equalsIgnoreCase("yes"))
//        {
            for(int i=0;i<book.size();i++)
            {
                cfg=new Configuration();
                cfg=cfg.configure();
                factory= cfg.buildSessionFactory();
                ses= factory.openSession();

                Book b1=new Book();
                b1.setBookId(book.get(i).getBookId());
                b1.setBookName(book.get(i).getBookName());
                b1.setBookPrice(book.get(i).getBookPrice());

                tx=ses.beginTransaction();
                ses.save(b1);
                tx.commit();
                ses.close();
                System.out.println("Data Inserted Successfully");
            }
        }
   // }
}
