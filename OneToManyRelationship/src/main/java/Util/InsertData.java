package Util;

import Model.Question;
import Model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Question.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Topic t1=new Topic("Constructor");
        Question q1=new Question("What is Constructor",t1);
        Question q2=new Question("Types Of Constructor",t1);
        Question q3=new Question("What is Constructor Chaining",t1);

        tx= ses.beginTransaction();
        ses.save(q1);
        ses.save(q2);
        ses.save(q3);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
