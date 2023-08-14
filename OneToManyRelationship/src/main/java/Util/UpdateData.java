package Util;

import Model.Question;
import Model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Question.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();



        Topic t1=ses.load(Topic.class,6);
//       Question q1=new Question();
//        Question q2=new Question();

        t1.settName("Polymorphism");
//        q1.setqName("What is Polymorphism");
//       q2.setqName("Types Of Polymorphism");

        tx=ses.beginTransaction();
        ses.update(t1);
//        ses.update(q1);
//        ses.update(q2);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
