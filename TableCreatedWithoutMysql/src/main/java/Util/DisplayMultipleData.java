package Util;

import Model.Operation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayMultipleData {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Operation.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Operation.class);
        List<Operation> data=crt.list();
        for(Operation d:data)
        {
            System.out.println(d.getId()+"\t"+d.getName()+"\t"+d.getAddress()+"\t"+d.getMarks());
        }
        ses.close();
    }
}
