package Util;

import Model.Operation;
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

        cfg=new Configuration().configure().addAnnotatedClass(Operation.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        Operation o1=ses.get(Operation.class,id);
        o1.setName("Ayush");
        o1.setAddress("Kharadi");
        o1.setMarks(99.99);

        tx= ses.beginTransaction();
        ses.update(o1);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
