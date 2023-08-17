package Util;

import Model.Customer2;
import Model.Product2;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

public class Program7 {     //to accept Product Name from end user & display the customerInfo who has purchase that product
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Product Name :");
        String pName=sc.next();

        Product2 p1=new Product2(pName);
        Criteria crt=ses.createCriteria(Product2.class);
        crt.add(Restrictions.eq("pName",pName));
        List<Product2> data=crt.list();
        for(Product2 d:data)
        {
            List<Customer2> data1=d.getCustomer2List();
            for (Customer2 c:data1)
            {
                System.out.println(c.getcName());
            }
        }

    }
}
