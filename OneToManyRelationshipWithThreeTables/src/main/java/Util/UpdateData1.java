package Util;

import Model.BankAccount;
import Model.Branch;
import Model.Customer3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class UpdateData1 {
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
        System.out.println("Enter a Customer Id :");
        int cId=sc.nextInt();
        System.out.println("Enter a Bank Account Id :");
        int baId=sc.nextInt();
        System.out.println("Enter a Account Type :");
        String baType=sc.next();

        Branch b1=ses.get(Branch.class,bId);
        List<Customer3> c1= b1.getCustomer3List();
        for(Customer3 temp:c1)
        {
            if(cId==temp.getcId())
            {
                Customer3 c2=ses.get(Customer3.class,cId);
                List<BankAccount> a1=c2.getBankAccountList();
                for(BankAccount a2:a1)
                {
                    if(a2.getBaNo()==baId)
                    {
                        a2.setBaType(baType);
                        tx= ses.beginTransaction();
                        ses.update(a2);
                        tx.commit();
                        System.out.println("Data Updated");
                    }
                }
            }
        }
    }
}
