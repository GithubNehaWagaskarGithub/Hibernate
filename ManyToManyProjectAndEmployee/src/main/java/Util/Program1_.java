package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Program1_ {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Employee Name :");
        String eName=sc.next();
        System.out.println("Enter a Employee Join Date :");
        String eJoinDate=sc.next();

        Employee e1=new Employee(eName,eJoinDate);

        System.out.println("Enter a No of Project Employee Want To Add :");
        int no=sc.nextInt();
        for(int i=0;i<no;i++)
        {
            System.out.println("Enter a Project Duration :");
            int pDu=sc.nextInt();
            System.out.println("Enter a Project Name :");
            String pName=sc.next();
            System.out.println("Enter a Project Type :");
            String pType=sc.next();

            Project p1=new Project(pName,pType,pDu);
            p1.addEmployee(e1);

            tx= ses.beginTransaction();
            ses.save(p1);
            tx.commit();
            System.out.println((i+1)+"Data Saved");
        }
        ses.close();
    }
}
