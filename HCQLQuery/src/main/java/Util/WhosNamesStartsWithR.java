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

public class WhosNamesStartsWithR {//Restriction is also class which helps to add Condition or Restriction on Objects.
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Student.class);
        crt.add(Restrictions.like("sName","R%"));
        List<Student> data=crt.list();
        for(Student d:data)
        {
            System.out.println(d.getsId()+"\t"+d.getsName()+"\t"+d.getsStream()+"\t"+d.getsFees());
        }

        Query q1=ses.createQuery("from Student where sName like 'R%'");
        ArrayList<Student> data1= (ArrayList<Student>) q1.getResultList();
        for(Student s:data1)
        {
            System.out.println(s.getsId()+"\t"+s.getsName()+"\t"+s.getsStream()+"\t"+s.getsFees());
        }
    }
}
