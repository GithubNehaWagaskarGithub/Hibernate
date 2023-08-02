package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData
{
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Book b1=new Book();
        b1.setBookId(4);
        b1.setBookName("J2ee");
        b1.setBookPrice(555.88);

        tx=ses.beginTransaction();
        ses.save(b1);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
