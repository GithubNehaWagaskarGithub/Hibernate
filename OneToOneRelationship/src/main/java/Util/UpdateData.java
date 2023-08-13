package Util;

import Model.AdharCard;
import Model.Person;
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

        cfg=new Configuration().configure().addAnnotatedClass(AdharCard.class).addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();


        Person p1=ses.get(Person.class,1);
        AdharCard a1= p1.getARef();
        a1.setUId(8002);

        tx= ses.beginTransaction();
        ses.update(p1);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
