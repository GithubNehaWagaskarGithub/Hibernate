package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DisplayData
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

        Book b=ses.load(Book.class,3);
        System.out.println("Data Is :");
        System.out.println(b.getBookId()+"\t"+b.getBookName()+"\t"+b.getBookPrice());

        tx=ses.beginTransaction();
        tx.commit();
        ses.close();

    }
}
