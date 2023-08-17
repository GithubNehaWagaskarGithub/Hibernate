package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt= ses.createCriteria(Employee.class);
        List<Employee> data=crt.list();
        for (Employee d:data)
        {
            System.out.println(d.geteNo()+"\t"+d.geteName()+"\t"+d.getJoinDate());
            List<Project> data1=d.getProjectList();
            for(Project p:data1)
            {
                System.out.println(p.getpNo()+"\t"+p.getpName()+"\t"+p.getpType()+"\t"+p.getpDuration());
            }
        }
    }
}
