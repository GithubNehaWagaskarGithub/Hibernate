package Util;

import Model.Customer1;
import Model.Product1;
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

        cfg = new Configuration().configure().addAnnotatedClass(Customer1.class).addAnnotatedClass(Product1.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt = ses.createCriteria(Customer1.class);
        List<Customer1> data = crt.list();
        for (Customer1 c : data) {
            System.out.println(c.getcName());
            List<Product1> data1 = c.getProduct1List();
            if (data1.size() == 2) {
                for (Product1 p : data1) {
                    System.out.println(p.getpName());
                }
            }
        }
    }
}
