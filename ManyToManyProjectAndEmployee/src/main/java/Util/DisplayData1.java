package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayData1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Employee No :");
        int eNo=sc.nextInt();
        Employee e1=ses.load(Employee.class,eNo);
        System.out.println(e1.geteNo()+"\t"+e1.geteName()+"\t"+e1.getJoinDate());
        List<Project> data=e1.getProjectList();
        for (Project d:data)
        {
            System.out.println(d.getpNo()+"\t"+d.getpName()+"\t"+d.getpType()+"\t"+d.getpDuration());
        }
    }
}
