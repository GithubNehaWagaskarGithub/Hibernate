package Util;

import Model.Question;
import Model.Topic;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayDataQueIsGreaterThan2 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Question.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt=ses.createCriteria(Topic.class);

        List<Topic> t1=crt.list();
        for(Topic d:t1)
        {
            System.out.println(d.gettName());
            List<Question> q1=d.getQuestionList();
            if(q1.size()>2)
            {
                for(Question q:q1)
                {
                    System.out.println(q.getqName());
                }
            }
        }
    }
}
