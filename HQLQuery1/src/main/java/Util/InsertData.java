package Util;

import Model.GuiClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class InsertData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(GuiClass.class);
        factory= cfg.buildSessionFactory();
        ses = factory.openSession();

        GuiClass g1=new GuiClass("Neha","10:00 Pm",2000);

        tx=ses.beginTransaction();
        ses.save(g1);
        tx.commit();
        ses.close();
        System.out.println("Data Added");
    }
}

