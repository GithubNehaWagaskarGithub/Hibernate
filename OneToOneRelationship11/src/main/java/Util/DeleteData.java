package Util;

import Model.Passport;
import Model.Person;
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

        cfg=new Configuration().configure().addAnnotatedClass(Passport.class).addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Person p1=ses.load(Person.class,100);

        tx= ses.beginTransaction();
        ses.delete(p1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
