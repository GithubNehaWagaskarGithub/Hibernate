package Util;

import Model.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteData1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Operation.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        Operation o1=ses.get(Operation.class,id);

        tx= ses.beginTransaction();
        ses.delete(o1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");

    }
}