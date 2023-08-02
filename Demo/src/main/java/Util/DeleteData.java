package Util;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        factory=new Configuration().configure().buildSessionFactory();
        ses= factory.openSession();

        Book b=ses.load(Book.class,6);

        tx=ses.beginTransaction();
        ses.delete(b);
        tx.commit();
        ses.close();
        System.out.println("Data Deleted");
    }
}
