package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertData1 {
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

        System.out.println("Enter a No Of Project Employee want to join :");
        int no=sc.nextInt();
        for(int i=0;i<no;i++)
        {
            System.out.println("Enter a Project Duration :");
            int pdu=sc.nextInt();
            System.out.println("Enter a Project Name :");
            String pName=sc.next();
            System.out.println("Enter a Project TYpe :");
            String pType=sc.next();
            Project p1=new Project(pName,pType,pdu);
            e1.addProject(p1);
            System.out.println("Data Inserted");
        }
        tx= ses.beginTransaction();
        ses.save(e1);
        tx.commit();
        ses.close();
    }
}
