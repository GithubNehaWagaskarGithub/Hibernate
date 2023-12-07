package Util;

import Model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FeesGreaterThan25000 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

//        Criteria crt=ses.createCriteria(Student.class);
//        crt.add(Restrictions.gt("sFees",25000.00));
//        List<Student> data=crt.list();
//        for(Student d:data)
//        {
//            System.out.println(d.getsId()+"\t"+d.getsName()+"\t"+d.getsStream()+"\t"+d.getsFees());
//        }
//
//        Query q1=ses.createQuery("from Student where sFees>25000.00");
//        ArrayList<Student> data1= (ArrayList<Student>) q1.getResultList();
//        for(Student s:data1)
//        {
//            System.out.println(s.getsId()+"\t"+s.getsName()+"\t"+s.getsStream()+"\t"+s.getsFees());
//        }

        Criteria crt1=ses.createCriteria(Student.class);
        crt1.add(Restrictions.lt("sId",6));
        List<Student> data3=crt1.list();
        for(Student a:data3)
        {
            System.out.println(a.getsId()+"\t"+a.getsName()+"\t"+a.getsStream()+"\t"+a.getsFees());
        }
    }
}
