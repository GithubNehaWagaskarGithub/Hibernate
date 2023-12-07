package Util;

import Model.Customer3;
import Model.Product3;
import org.hibernate.Criteria;
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

        cfg=new Configuration().configure().addAnnotatedClass(Product3.class).addAnnotatedClass(Customer3.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt= ses.createCriteria(Customer3.class);
        List<Customer3> data=crt.list();
        for(Customer3 c:data)
        {
            System.out.println(c.getcId()+"\t"+c.getcName());
            List<Product3> data1=c.getProduct3List();
            for(Product3 p:data1)
            {
                System.out.println(p.getpId()+"\t"+p.getpName()+"\t"+p.getpPrice());
            }
        }
    }
}
