package Util;

import Model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import java.util.List;

public class Program32 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Criteria crt= ses.createCriteria(Employee.class);
        crt.addOrder(Order.desc("empSal"));

        List<Employee> data=crt.list();
        for(Employee d:data)
        {
            System.out.println(d.getEmpId()+"\t"+d.getEmpName()+"\t"+d.getEmpDesig()+"\t"+d.getEmpSal());
        }
    }
}
