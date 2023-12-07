package Util;

import Model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

public class LessThanGreaThanOrEqualTo {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration().configure().addAnnotatedClass(Student.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt=ses.createCriteria(Student.class);
        crt.add(Restrictions.le("sFees",40000.00));
        List<Student> data=crt.list();
        for(Student d:data)
        {
            System.out.println(d.getsId()+"\t"+d.getsName()+"\t"+d.getsStream()+"\t"+d.getsFees());
        }

        Criteria crt1=ses.createCriteria(Student.class);
        crt1.add(Restrictions.ge("sFees",35999.00));
        List<Student> data1=crt1.list();

        for(Student d1:data1)
        {
            System.out.println(d1.getsId()+"\t"+d1.getsName()+"\t"+d1.getsStream()+"\t"+d1.getsFees());
        }


    }
}
