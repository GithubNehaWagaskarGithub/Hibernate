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

public class Program4 {        //display Product Name whos product Price is less than 15000
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer2.class).addAnnotatedClass(Product2.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Product2.class);
        crt.add(Restrictions.lt("pPrice",15000.00));
        List<Product2> data=crt.list();
        for(Product2 d:data)
        {
            System.out.println(d.getpName());
        }
    }
}
