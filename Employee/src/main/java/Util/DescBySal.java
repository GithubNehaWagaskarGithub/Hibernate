package Util;

import Model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;

public class DescBySal {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Query q1 = ses.createQuery("from Employee order by empSal desc");
        
        ArrayList<Employee> res = (ArrayList<Employee>) q1.getResultList();

        System.out.println("Emp Sal In Descending Order :");
        for(Employee data:res)
        {
            System.out.println(data.getEmpId()+"\t"+data.getEmpName()+"\t"+data.getEmpDesig()+"\t"+ data.getEmpSal());
        }

        System.out.println();
        System.out.println("Printing values:");
        for (Employee emp : res)
        {
            System.out.println(emp);
        }
    }
}

