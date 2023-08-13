package Util;

import Model.Operation;
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

        cfg=new Configuration().configure().addAnnotatedClass(Operation.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter a No do you want to Insert data :");
        int no=sc.nextInt();
        for(int i=0;i<no;i++)
        {
            System.out.println("Enter Name :");
            String name=sc.next();
            System.out.println("Enter Address :");
            String add=sc.next();
            System.out.println("Enter a Marks :");
            double marks=sc.nextDouble();
            Operation o1=new Operation(name,add,marks);
            tx= ses.beginTransaction();
            ses.save(o1);
            tx.commit();
        }

        ses.close();
        System.out.println("Data Inserted");
    }
}
