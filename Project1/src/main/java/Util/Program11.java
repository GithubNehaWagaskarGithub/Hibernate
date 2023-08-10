package Util;

import Model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Program11 {
    public static void main(String[] args) {        //salary between 10000 and 20000
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt= ses.createCriteria(Employee.class);
        crt.add(Restrictions.between("empSal",10000.00,20000.00));

        List<Employee> data=crt.list();
        for(Employee d:data)
        {
            System.out.println(d.getEmpSal());
        }
    }
}
