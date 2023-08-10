package Util;

import Model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class Program1 {                             //Salary is greater than 25000
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt=ses.createCriteria(Employee.class);
        crt.add(Restrictions.lt("empSal",25000.00));
        List<Employee> data=crt.list();
        for(Employee d:data)
        {
            System.out.println(d.getEmpId()+"\t"+d.getEmpName()+"\t"+d.getEmpDesig()+"\t"+d.getEmpSal());
        }
        //----------------------------------------------------------------------------------------------------------

        crt.add(Restrictions.gt("empSal",25000.00));  //Salary is less than 25000
        List<Employee> data1=crt.list();
        for(Employee d1:data1)
        {
            System.out.println(d1.getEmpId()+"\t"+d1.getEmpName()+"\t"+d1.getEmpDesig()+"\t"+d1.getEmpSal());
        }


    }
}
