package Util;

import Model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertDataEndUser
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Name :");
        String name=sc.next();
        System.out.println("Enter a Desig :");
        String desig=sc.next();
        System.out.println("Enter a Sal :");
        double sal=sc.nextDouble();

        Employee e1=new Employee();
        e1.setEmpId(id);
        e1.setEmpName(name);
        e1.setEmpDesig(desig);
        e1.setEmpSal(sal);

        tx=ses.beginTransaction();
        ses.save(e1);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
