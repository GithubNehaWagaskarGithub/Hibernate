package Util;

import Model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ORQuery {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Student.class);
        Criterion crt1=Restrictions.le("sFees",25000.00);
        Criterion crt2=Restrictions.like("sName","A%");

        LogicalExpression le=Restrictions.and(crt1,crt2);
        crt.add(le);
        List<Student> data=crt.list();
        for(Student d:data)
        {
            System.out.println(d.getsId()+"\t"+d.getsName()+"\t"+d.getsStream()+"\t"+d.getsFees());
        }
    }
}
