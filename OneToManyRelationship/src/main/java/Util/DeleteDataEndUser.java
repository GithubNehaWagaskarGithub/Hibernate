package Util;

import Model.Question;
import Model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteDataEndUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Question.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        System.out.println("Enter a Topic Id :");
        int id=sc.nextInt();
        Topic t1=ses.get(Topic.class,id);

        tx=ses.beginTransaction();
        ses.delete(t1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
