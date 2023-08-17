package Util;

import Model.Customer2;
import Model.Product2;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

public class Program3 {     //to display customerName who has purchase exactly two Products
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt= ses.createCriteria(Customer2.class);
        crt.add(Restrictions.sizeEq("product2List",2));
        List<Customer2> data=crt.list();

        for(Customer2 d:data)
        {
            System.out.println(d.getcName());
        }
    }
}
