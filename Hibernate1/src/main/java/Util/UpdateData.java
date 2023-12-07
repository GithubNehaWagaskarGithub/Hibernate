package Util;


import Model.Customer1;
import Model.Product1;
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

        cfg=new Configuration().configure().addAnnotatedClass(Customer1.class).addAnnotatedClass(Product1.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        Customer1 c1=ses.load(Customer1.class,id);
        System.out.println("Enter a newCustName :");
        String newCustName=sc.next();
        c1.setcName(newCustName);
        List<Product1> data=c1.getProduct1List();
        for(Product1 p:data)
        {
            Product1 p1=ses.load(Product1.class,p.getpId());
            System.out.println(p.getpId()+"\t"+p.getpName());
            System.out.println("Yes/No");
            String  input=sc.next();
            if(input.equalsIgnoreCase("Yes"))
            {
                System.out.println("Enter a Product Name :");
                sc.nextLine();
                String newProductName=sc.nextLine();
                p1.setpName(newProductName);

                tx=ses.beginTransaction();
                ses.save(p1);
                tx.commit();
                System.out.println("Data Updated");
            }
        }
        ses.close();
    }
}
