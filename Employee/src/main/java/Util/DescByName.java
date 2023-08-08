package Util;

import Model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;


public class DescByName {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Query data = ses.createQuery("from Employee e1 order by e1.empName desc");

        ArrayList<Employee> res = (ArrayList<Employee>) data.getResultList();

        System.out.println("Employee Name in Descending Order :");
        for (Employee emp : res)
        {
            System.out.println(emp.getEmpId() + "\t"+emp.getEmpName() + "\t"+emp.getEmpDesig() + "\t"+emp.getEmpSal());
        }

        System.out.println();
        System.out.println("Printing values:");
        for (Employee emp : res)
        {
            System.out.println(emp);
        }
    }
}
