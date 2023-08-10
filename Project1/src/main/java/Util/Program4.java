package Util;

import Model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import java.util.Iterator;
import java.util.List;

public class Program4 {         //maximum salary
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt = ses.createCriteria(Employee.class);
        crt.setProjection(Projections.max("empSal"));
        List<Double> data=crt.list();
        Iterator<Double> itr= data.iterator();
        System.out.println("Maximum Salary :");
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }

        crt.setProjection(Projections.min("empSal"));       //minimum salary
        List<Double> data1=crt.list();
        Iterator<Double> itr1= data1.iterator();
        System.out.println("Minimum Salary :");
        while (itr1.hasNext())
        {
            System.out.println(itr1.next());
        }
    }
}
