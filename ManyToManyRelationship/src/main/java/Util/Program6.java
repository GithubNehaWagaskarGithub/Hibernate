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

public class Program6 {     //to display ProductName which is only 1 buyer
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt= ses.createCriteria(Product2.class);
        crt.add(Restrictions.sizeEq("customer2List",1));
        List<Product2> data=crt.list();

        for(Product2 d:data)
        {
            System.out.println(d.getpName());
        }
    }
}
