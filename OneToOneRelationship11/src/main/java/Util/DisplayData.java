package Util;

import Model.Passport;
import Model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Passport.class).addAnnotatedClass(Person.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

//        Person p1=ses.load(Person.class,100);
//        System.out.println(p1.getpId()+"\t"+p1.getpName()+"\t"+p1.getpCity()+"\t"+p1.getPassRef().getPassId()+"\t"+p1.getPassRef().getPassName()+"\t"+p1.getPassRef().getPassCountry());

        Criteria crt=ses.createCriteria(Person.class);
        List<Person> data=crt.list();
        for(Person d:data)
        {
            System.out.println(d.getpId()+"\t"+d.getpName()+"\t"+d.getpCity()+"\t"+d.getPassRef().getPassId()+"\t"+d.getPassRef().getPassName()+"\t"+d.getPassRef().getPassCountry());
        }
    }
}
