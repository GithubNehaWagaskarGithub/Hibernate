package Util;

import Model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;


public class SecondHighSal_ {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Query q2 = ses.createQuery("from Employee e1 order by e1.empSal desc limit 2");
        ArrayList<Employee> res = (ArrayList<Employee>) q2.getResultList();
        for (Employee emp : res)
        {
            System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpDesig()+"\t"+emp.getEmpSal()+"\t");
        }

        System.out.println();
        System.out.println("Printing values:");
        for (Employee emp : res)
        {
            System.out.println(emp);
        }
    }
}

