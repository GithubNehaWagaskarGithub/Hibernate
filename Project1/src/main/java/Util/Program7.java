package Util;

import Model.Employee;
import com.sun.source.tree.WhileLoopTree;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

public class Program7 {         //salary is greater than 25000 in asc order
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Employee.class);
        crt.addOrder(Order.asc(String.valueOf(Restrictions.gt("empSal",25000.00))));

        List<Employee> data=crt.list();
        //Iterator itr=data.iterator();
        for(Employee d:data)
        {
            System.out.println(d.getEmpId()+"\t"+d.getEmpName()+"\t"+d.getEmpDesig()+"\t"+d.getEmpSal());
        }
//        while (itr.hasNext())
//        {
//            System.out.println(itr.next());
//        }
    }
}
