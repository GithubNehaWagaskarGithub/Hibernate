package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Program3 {     //accept project No from end user and delete all emp info who working on that project
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter Project No :");
        int pNo=sc.nextInt();
        Project p1=ses.load(Project.class,pNo);

        tx= ses.beginTransaction();;
        ses.delete(p1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
