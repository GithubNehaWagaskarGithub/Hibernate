package Util;


import Model.Student;
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

        cfg=new Configuration().configure().addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Student s1=new Student("Neha","CS",45000);

        tx=ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        ses.close();
        System.out.println("Data Added");
    }
}
