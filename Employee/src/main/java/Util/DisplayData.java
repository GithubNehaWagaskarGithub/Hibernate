package Util;

import Model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;


public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Query q = ses.createQuery("from Employee  ");

        ArrayList<Employee> res1 = (ArrayList<Employee>) q.getResultList();

        for (Employee emp : res1)
        {
            System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpDesig()+"\t"+emp.getEmpSal());
        }
    }
}