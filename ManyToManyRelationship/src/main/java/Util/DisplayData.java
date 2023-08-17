package Util;

import Model.Customer2;
import Model.Product2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer2 c1=ses.load(Customer2.class,1);
        System.out.println(c1.getcName());
        List<Product2> data=c1.getProduct2List();
        for(Product2 p:data)
        {
            System.out.println(p.getpId()+"\t"+p.getpName()+"\t"+p.getpPrice());
        }
    }
}
