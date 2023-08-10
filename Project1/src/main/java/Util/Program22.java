package Util;

import Model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import java.util.Iterator;
import java.util.List;


public class Program22 {        //count of Emp Designation
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Employee.class);
        crt.setProjection(Projections.countDistinct("empDesig"));

        List<Integer> data=crt.list();
        Iterator<Integer> itr= data.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
