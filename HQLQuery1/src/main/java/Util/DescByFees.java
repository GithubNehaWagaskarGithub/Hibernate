package Util;

import Model.GuiClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;


public class DescByFees {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(GuiClass.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Query q1=ses.createQuery("from GuiClass order by Fees desc");

        ArrayList<GuiClass> data= (ArrayList<GuiClass>) q1.getResultList();
        for(GuiClass d:data)
        {
            System.out.println(d.getgId()+"\t"+d.getgName()+"\t"+d.getTime()+"\t"+d.getFees());
        }
    }
}
