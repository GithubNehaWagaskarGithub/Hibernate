package Util;

import Model.Question;
import Model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Question.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Topic t1=ses.get(Topic.class,6);

        tx=ses.beginTransaction();
        ses.delete(t1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
