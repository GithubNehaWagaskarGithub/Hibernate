package Util;

import Model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class AscOrderByFees {//Order is Class
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Student.class);
        crt.addOrder(Order.asc("sFees"));
        List<Student> data=crt.list();
        for(Student d:data)
        {
            System.out.println(d.getsId()+"\t"+d.getsName()+"\t"+d.getsStream()+"\t"+d.getsFees());
        }

        Query q1=ses.createQuery("from Student order by sFees asc");
        ArrayList<Student> data1= (ArrayList<Student>) q1.getResultList();

        for(Student s:data1)
        {
            System.out.println(s.getsId()+"\t"+s.getsName()+"\t"+s.getsStream()+"\t"+s.getsFees());
        }
    }
}
