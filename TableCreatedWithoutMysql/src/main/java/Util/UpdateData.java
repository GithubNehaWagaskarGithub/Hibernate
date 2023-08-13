package Util;

import Model.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Operation.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Operation o1=ses.get(Operation.class,1);
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
