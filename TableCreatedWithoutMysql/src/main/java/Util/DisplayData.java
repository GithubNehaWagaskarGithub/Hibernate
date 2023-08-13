package Util;

import Model.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Operation.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Operation o1=ses.get(Operation.class,1);
        System.out.println(o1.getId()+"\t"+o1.getAddress()+"\t"+o1.getMarks()+"\t"+o1.getName());

        ses.close();
    }
}
