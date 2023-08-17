package Util;

import Model.Customer2;
import Model.Product2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertData1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Customer Name :");
        String cName=sc.next();

        Customer2 c1=new Customer2(cName);

        System.out.println("Enter a No of Product:");
        int pno=sc.nextInt();
        for(int i=0;i<pno;i++)
        {
            System.out.println("Enter a Product Name :");
            String pName=sc.next();
            System.out.println("Enter a Product Price :");
            double price=sc.nextDouble();

            Product2 p1=new Product2(pName,price);
            c1.addData(p1);
        }
        tx= ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("Data Inserted");
        ses.close();
    }
}
