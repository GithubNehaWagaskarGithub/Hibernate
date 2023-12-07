package Util;

import Model.GuiClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondMaxSal {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(GuiClass.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Query q1=ses.createQuery("from GuiClass order by Fees desc");
        q1.setMaxResults(2);
        ArrayList<GuiClass> data= (ArrayList<GuiClass>) q1.getResultList();
        if(data.size()>=2)
        {
            GuiClass g1=data.get(1);
            System.out.println(g1.getgId()+"\t"+g1.getgName()+"\t"+g1.getTime()+"\t"+g1.getFees());
        }
        for(GuiClass d:data)
        {
            //System.out.println(d.getgId()+"\t"+d.getgName()+"\t"+d.getTime()+"\t"+d.getFees());
        }
    }
}
