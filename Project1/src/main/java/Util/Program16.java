package Util;


import Model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Program16 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Employee.class);
        Criterion sal= Restrictions.gt("empSal",25000.00);
        Criterion name=Restrictions.like("empDesig","D%");

        LogicalExpression expAnd=Restrictions.and(sal,name);
        crt.add(expAnd);

        List<Employee> data= crt.list();
        for(Employee d:data)
        {
            System.out.println(d.getEmpId()+"\t"+d.getEmpName()+"\t"+d.getEmpDesig()+"\t"+d.getEmpSal());
        }

    }
}
