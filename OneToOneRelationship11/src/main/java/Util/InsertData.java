package Util;


import Model.Passport;
import Model.Person;
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

        cfg=new Configuration().configure().addAnnotatedClass(Passport.class).addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Passport p1=new Passport("Neha Wagaskar","India");
        Person p2=new Person("Neha","Pune",p1);

        Passport p3=new Passport("Mayuri Wagaskar","India");
        Person p4=new Person("Mayuri","Pune",p3);

        tx= ses.beginTransaction();
        ses.save(p2);
        ses.save(p4);
        tx.commit();
        ses.close();
        System.out.println("Data Added");
    }
}
