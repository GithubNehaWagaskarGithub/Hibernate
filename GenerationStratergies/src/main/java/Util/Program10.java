package Util;


import Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Program10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();

        System.out.println("Data Is :");
        Customer c1=ses.load(Customer.class,id);
        System.out.println(c1.getcId()+"\t"+c1.getcName()+"\t"+c1.getsAdd());

        tx= ses.beginTransaction();
        tx.commit();
        ses.close();
    }
}
