package Util;

import Model.ContractEmp;
import Model.Employee2;
import Model.PermanentEmp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee2.class).addAnnotatedClass(ContractEmp.class).addAnnotatedClass(PermanentEmp.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        ContractEmp c1=ses.load(ContractEmp.class,id);
        System.out.println("Enter a Time Duration :");
        String timeDu=sc.next();
        c1.setTimeDuration(timeDu);

        tx= ses.beginTransaction();
        ses.update(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
