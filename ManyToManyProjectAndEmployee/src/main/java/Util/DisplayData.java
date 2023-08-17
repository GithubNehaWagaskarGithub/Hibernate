package Util;

import Model.Employee;
import Model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Employee e1=ses.load(Employee.class,1);
        System.out.println(e1.geteNo()+"\t"+e1.geteName()+"\t"+e1.getJoinDate());
        List<Project> data=e1.getProjectList();
        for(Project p:data)
        {
            System.out.println(p.getpNo()+"\t"+p.getpName()+"\t"+p.getpType()+"\t"+p.getpDuration());
        }
    }
}
