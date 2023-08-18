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

public class UpdateData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(Customer3.class).addAnnotatedClass(BankAccount.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Branch b1=ses.load(Branch.class,1000);
        List<Customer3> data=b1.getCustomer3List();
        for(Customer3 d:data)
        {
            Customer3 c1=ses.load(Customer3.class,d.getcId());
            List<BankAccount> data1=c1.getBankAccountList();
            System.out.println("Do You want to Update Record Yes?No");
            String input=sc.next();
            if(input.equalsIgnoreCase("Yes"))
            {
                System.out.println("Enter a New Customer Name :");
                sc.nextLine();
                String newQue=sc.nextLine();
                c1.setcName(newQue);
                System.out.println("Enter a Customer City :");
                sc.nextLine();
                String city=sc.nextLine();
                c1.setcCity(city);
                System.out.println("Enter a Branch Ref :");
                sc.nextLine();
                int bRef= sc.nextInt();
                c1.setbRef(b1);
                System.out.println("Data Updated");
            }
            for(BankAccount a:data1) {
                BankAccount a1 = ses.load(BankAccount.class, a.getBaNo());
                System.out.println("Do You want to Update Record Yes?No");
                String input1 = sc.next();
                if (input.equalsIgnoreCase("Yes")) {
                    System.out.println("Enter a New Account Holder Name :");
                    sc.nextLine();
                    String newHolder = sc.nextLine();
                    a1.setBaName(newHolder);
                    System.out.println("Enter a Account Type :");
                    sc.nextLine();
                    String aType= sc.next();
                    a1.setBaType(aType);
                    System.out.println("Enter a Account Balance :");
                    sc.nextLine();
                    double aBal= sc.nextDouble();
                    a1.setBaBalance(aBal);
                    System.out.println("Enter a Customer Ref :");
                    sc.nextLine();
                    int cRef= sc.nextInt();
                    a1.setcRef(c1);
                    System.out.println("Data Updated");
                }
            }
        }
        //ses.update();
    }
}
