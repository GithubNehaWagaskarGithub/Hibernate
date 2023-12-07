package Util;

import Model.Customer1;
import Model.Product1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DeleteData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Customer1.class).addAnnotatedClass(Product1.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer1 c1=ses.load(Customer1.class,1002);

        tx=ses.beginTransaction();
        ses.delete(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
