package Util;

import Model.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DisplayData1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Operation.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter A Id :");
        int id=sc.nextInt();

        Operation o1=ses.get(Operation.class,id);
        System.out.println(o1.getId()+"\t"+o1.getName()+"\t"+o1.getAddress()+"\t"+ o1.getMarks());

        ses.close();
    }
}
