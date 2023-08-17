package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Program4 {     //display on each project how many emp are working
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt= ses.createCriteria(Project.class);
        List<Project> data=crt.list();
        for(Project d:data)
        {
            System.out.println(d.getpName());
            List<Employee> data1=d.getEmployeeList();
            for(Employee e:data1)
            {
                System.out.println(e.geteName());
            }
        }
//        Criteria crt= ses.createCriteria(Project.class);
//        crt.add(Restrictions.eq("pName",crt.setProjection(Projections.count("eName"))));
//        List<Integer> data=crt.list();
//        for (Integer d:data)
//        {
//            System.out.println(d.intValue());
//        }
    }
}
