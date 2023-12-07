package Util;

import Model.GuiClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;


public class AscByName {
    public static void main(String[] args) {
        Configuration cfg;
        Session ses;
        SessionFactory factory;

        cfg = new Configuration().configure().addAnnotatedClass(GuiClass.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

//        Query data=ses.createQuery("from GuiClass order by gName");
//        ArrayList<GuiClass> name=(ArrayList<GuiClass>) data.getResultList();
//        for(GuiClass n:name)
//        {
//            System.out.println(n.getgId()+"\t"+n.getgName()+"\t"+n.getFees());
//        }

        Query q = ses.createQuery("from GuiClass order by Fees");

        ArrayList<GuiClass> res1 = (ArrayList<GuiClass>) q.getResultList();

        for (GuiClass emp : res1)
        {
            System.out.println(emp.getgId()+"\t"+emp.getgName()+"\t"+emp.getFees()+"\t"+emp.getTime());
        }
//        for(GuiClass n:name)
//        {
//            System.out.println(n);
//        }
    }
}
