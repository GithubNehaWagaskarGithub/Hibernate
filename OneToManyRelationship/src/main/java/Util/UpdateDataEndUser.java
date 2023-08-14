package Util;

import Model.Question;
import Model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class UpdateDataEndUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Topic.class).addAnnotatedClass(Question.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter Topic Id :");
        int id=sc.nextInt();

        Topic t1=ses.get(Topic.class,id);
        List<Question> q1=t1.getQuestionList();
        for(Question d:q1)
        {
            Question temp=ses.load(Question.class,d.getqId());
            System.out.println(temp.getqName());
            System.out.println("Do You want to Update Record Yes?No");
            String input=sc.next();
            if(input.equalsIgnoreCase("Yes"))
            {
                System.out.println("Enter a New Question :");
                sc.nextLine();
                String newQue=sc.nextLine();
                temp.setqName(newQue);
                tx= ses.beginTransaction();
                ses.update(temp);
                tx.commit();

                System.out.println("Data Updated");
            }
        }
        ses.close();
    }
}
