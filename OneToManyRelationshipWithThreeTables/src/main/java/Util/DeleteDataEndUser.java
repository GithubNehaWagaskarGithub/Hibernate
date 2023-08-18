package Util;

import Model.BankAccount;
import Model.Branch;
import Model.Customer3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteDataEndUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(Customer3.class).addAnnotatedClass(BankAccount.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Branch Id :");
        int bId=sc.nextInt();
        Branch b1=ses.load(Branch.class,bId);
        tx=ses.beginTransaction();
        ses.delete(b1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
