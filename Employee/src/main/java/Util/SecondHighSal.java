package Util;

import Model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;


public class SecondHighSal {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Query q1 = ses.createQuery("from Employee order by empSal desc");
        q1.setMaxResults(2); // Second-Highest Sal

        ArrayList<Employee> res3 = (ArrayList<Employee>) q1.getResultList();

        if (res3.size() >= 2)
        {
            Employee secondHighest = res3.get(1);
            System.out.println("Second Highest Salary Employee:");
            System.out.println(secondHighest.getEmpId()+"\t"+secondHighest.getEmpName()+"\t"+secondHighest.getEmpDesig()+"\t"+secondHighest.getEmpSal());
        } else {
            System.out.println("Not enough employees to determine the second highest salary.");
        }

        System.out.println();
        System.out.println("Printing values:");
        for (Employee emp : res3)
        {
            System.out.println(emp);
        }
    }
}

