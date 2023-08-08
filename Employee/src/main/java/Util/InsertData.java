package Util;

import Model.Employee;
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

        cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        factory= cfg.buildSessionFactory();
        ses = factory.openSession();

        Employee e1 = new Employee();

        e1.setEmpId(101);
        e1.setEmpName("Akash");
        e1.setEmpDesig("DEVELOPER");
        e1.setEmpSal(29900.9);

        tx = ses.beginTransaction();
        ses.save(e1);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}