package Util;

import Model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Student.class);
        crt.add(Restrictions.gt("sFees",25000.00));
        crt.addOrder(Order.asc("sFees"));
        List<Student> data=crt.list();
        for(Student d:data)
        {
            System.out.println(d.getsId()+"\t"+d.getsName()+"\t"+d.getsStream()+"\t"+d.getsFees());
        }
    }
}
