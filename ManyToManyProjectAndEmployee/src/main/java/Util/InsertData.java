package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Employee e1=new Employee("Neha","13-June-2023");
        Project p1=new Project("Bank_Management_System","Desktop_Project",5);
        Project p2=new Project("Library_Management_System","Desktop_Project",9);

        e1.addProject(p1);
        e1.addProject(p2);

        tx= ses.beginTransaction();
        ses.save(e1);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
