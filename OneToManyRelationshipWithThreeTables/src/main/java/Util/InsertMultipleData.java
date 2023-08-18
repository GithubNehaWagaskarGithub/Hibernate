package Util;

import Model.BankAccount;
import Model.Branch;
import Model.Customer3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertMultipleData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(Customer3.class).addAnnotatedClass(BankAccount.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        System.out.println("Enter a No Do you Want to Insert Data :");
        int no=sc.nextInt();
        for(int i=0;i<no;i++)
        {
            System.out.println("Enter a Branch Address :");
            String bAdd=sc.next();
            System.out.println("Enter a Branch IFSC Code :");
            String bIfscCode=sc.next();
            Branch b1=new Branch(bAdd,bIfscCode);

            System.out.println("Enter a Customer Name :");
            String cName=sc.next();
            System.out.println("Enter a Customer City :");
            String cCity=sc.next();
            Customer3 c1=new Customer3(cName,cCity,b1);

            System.out.println("Enter a No of Bank Account :");
            int baNo=sc.nextInt();
            for(int j=0;j<baNo;j++)
            {
                System.out.println("Enter a Bank Account Holder Name :");
                String baName=sc.next();
                System.out.println("Enter a BanK Account Type :");
                String baType=sc.next();
                System.out.println("Enter a Bank Account Balance :");
                double baBalance=sc.nextDouble();
                BankAccount a1=new BankAccount(baName,baType,baBalance,c1);
                tx= ses.beginTransaction();
                ses.save(a1);
                tx.commit();
            }
        }
        ses.close();
        System.out.println("Data Inserted");
    }
}
