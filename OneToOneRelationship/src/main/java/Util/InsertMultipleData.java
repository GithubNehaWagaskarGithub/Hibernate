package Util;

import Model.AdharCard;
import Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertMultipleData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(AdharCard.class).addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter a No do you want to Insert data");
        int no=sc.nextInt();
        for(int i=0;i<no;i++)
        {
            System.out.println("Enter Name Of Adhar Card :");
            String aName=sc.next();
            System.out.println("Enter UId :");
            int uId=sc.nextInt();
            System.out.println("Enter a Person Name :");
            String pName=sc.next();
            System.out.println("Enter Person Add :");
            String pAdd=sc.next();
            AdharCard a1=new AdharCard(aName,uId);
            Person p1=new Person(pName,pAdd,a1);
            tx= ses.beginTransaction();
            ses.save(p1);
            tx.commit();
        }

        ses.close();
        System.out.println("Data Inserted");
    }
}
