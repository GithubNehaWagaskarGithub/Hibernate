package Util;

import Model.BankAccount;
import Model.Branch;
import Model.Customer3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Display1 {     //display All Information
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(Customer3.class).addAnnotatedClass(BankAccount.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Account No :");
        int aNo=sc.nextInt();
        BankAccount a1=ses.load(BankAccount.class,aNo);
        Customer3 c1=a1.getcRef();
        Branch b1=c1.getbRef();

        System.out.println(a1.getBaNo()+"\t"+a1.getBaName()+"\t"+a1.getBaType()+"\t"+ a1.getBaBalance());
        System.out.println(c1.getcId()+"\t"+c1.getcName()+"\t"+c1.getcCity());
        System.out.println(b1.getbId()+"\t"+b1.getbAdd()+"\t"+b1.getIfscCode());
    }
}
