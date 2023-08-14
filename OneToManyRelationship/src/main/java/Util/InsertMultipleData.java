package Util;

import Model.Question;
import Model.Topic;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class InsertMultipleData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Question.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter a No do you want to Insert data :");
        int no=sc.nextInt();
        for(int i=0;i<no;i++)
        {
            System.out.println("Enter a Topic Name :");
            String tName=sc.next();
            System.out.println("Enter a Question 1 :");
            String que=sc.next();
            System.out.println("Enter a Question 2 :");
            String que1=sc.next();

            Topic t1=new Topic(tName);
            Question q1=new Question(que,t1);
            Question q2=new Question(que1,t1);

            tx= ses.beginTransaction();
            ses.save(q1);
            ses.save(q2);
            tx.commit();

        }
        ses.close();
        System.out.println("Data Inserted");
    }
}
