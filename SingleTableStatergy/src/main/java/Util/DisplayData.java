package Util;

import Model.ContractEmp;
import Model.Employee2;
import Model.PermanentEmp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee2.class).addAnnotatedClass(ContractEmp.class).addAnnotatedClass(PermanentEmp.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
//        Employee2 e1=ses.load(Employee2.class,id);
//        System.out.println(e1.geteId()+"\t"+e1.geteSal()+"\t"+e1.geteName());
//        ContractEmp c1=ses.load(ContractEmp.class,id);
//        System.out.println(c1.geteId()+"\t"+c1.geteName()+"\t"+c1.geteSal()+"\t"+c1.getTimeDuration()+"\t"+c1.getConDesi());
//        PermanentEmp p1=ses.load(PermanentEmp.class,id);
//        System.out.println(p1.geteId()+"\t"+p1.geteName()+"\t"+p1.geteSal()+"\t"+p1.getPerDesi()+"\t"+p1.getPfNo());

        Employee2 e1=ses.load(Employee2.class,id);
        System.out.println(e1.geteId()+"\t"+e1.geteName()+"\t"+e1.geteSal());

        Employee2 e2=new ContractEmp();
        //ContractEmp c1=ses.load(ContractEmp.class,id);
        ContractEmp c2=(ContractEmp) e2;
        System.out.println(c2.geteId()+"\t"+c2.geteName()+"\t"+c2.geteSal()+"\t"+c2.getTimeDuration()+"\t"+c2.getConDesi());


        Employee2 e3=new PermanentEmp();
        //PermanentEmp p1=ses.load(PermanentEmp.class,id);
        PermanentEmp p2=(PermanentEmp) e3;
        System.out.println(p2.geteId()+"\t"+p2.geteName()+"\t"+p2.geteSal()+"\t"+p2.getPerDesi()+"\t"+p2.getPfNo());
    }
}
