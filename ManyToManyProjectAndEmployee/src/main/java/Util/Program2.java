package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

public class Program2 {     //display employees who work on same project
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

//        System.out.println("Enter a Project No :");
//        int pNo=sc.nextInt();
//        Project p1=ses.load(Project.class,pNo);
//        System.out.println(p1.getpName());
//        List<Employee> data=p1.getEmployeeList();
//        for(Employee e:data)
//        {
//            System.out.println(e.geteName());
//        }
        System.out.println("Enter a Project Name :");
        String pName=sc.next();
        Criteria crt= ses.createCriteria(Project.class);
        crt.add(Restrictions.eq("pName",pName));
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
    }
}
