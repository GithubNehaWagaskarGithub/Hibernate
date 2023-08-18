package Util;

import Model.ContractEmp;
import Model.Employee2;
import Model.PermanentEmp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteData {
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
        Employee2 e1=ses.load(Employee2.class,id);

        tx= ses.beginTransaction();
        ses.delete(e1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
