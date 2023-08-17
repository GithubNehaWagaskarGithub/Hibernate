package Util;

import Model.Customer2;
import Model.Product2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Program1 {     //accept productInfo from end user and No of CustInfo who want to buy that Product
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Product Name :");
        String pName=sc.next();
        System.out.println("Enter a Product Price :");
        double pPrice=sc.nextDouble();

        Product2 p1=new Product2(pName,pPrice);

        System.out.println("Enter a No of Customer :");
        int no=sc.nextInt();
        for(int i=0;i<no;i++)
        {
            System.out.println("Enter a Customer Name :");
            String cName=sc.next();

            Customer2 c1=new Customer2(cName);
            c1.addData(p1);

            tx= ses.beginTransaction();
            ses.save(c1);
            tx.commit();
            System.out.println((i+1)+"Data Saved");
        }
        ses.close();
    }
}
