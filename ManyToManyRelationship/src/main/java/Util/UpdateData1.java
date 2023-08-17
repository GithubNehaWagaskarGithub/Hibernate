package Util;

import Model.Customer2;
import Model.Product2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateData1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Product Id :");
        int pId=sc.nextInt();
        System.out.println("Enter a Product Price :");
        double pPrice=sc.nextDouble();
        Product2 p1=ses.load(Product2.class,pId);
        p1.setpPrice(pPrice);

        System.out.println("Enter a Customer Id :");
        int cId=sc.nextInt();
        System.out.println("Enter a Customer Name :");
        String cName=sc.next();
        Customer2 c1=ses.load(Customer2.class,cId);
        c1.setcName(cName);

        tx= ses.beginTransaction();
        ses.update(p1);
        ses.update(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
