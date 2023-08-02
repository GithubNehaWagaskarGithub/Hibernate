package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Book b=ses.load(Book.class,3);
        b.setBookName("HTML");
        b.setBookPrice(599.88);

        tx=ses.beginTransaction();
        ses.update(b);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
