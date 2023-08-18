package Util;

import Model.ContractEmp;
import Model.Employee2;
import Model.PermanentEmp;
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

        cfg=new Configuration().configure().addAnnotatedClass(Employee2.class).addAnnotatedClass(ContractEmp.class).addAnnotatedClass(PermanentEmp.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        PermanentEmp p1=new PermanentEmp("Neha",25999.99,"Dev",12345);
        ContractEmp c1=new ContractEmp("Pooja",35999.99,"3Years","Test");

        tx= ses.beginTransaction();
        ses.save(p1);
        ses.save(c1);
        tx.commit();
        ses.close();
        factory.close();
        System.out.println("Data Inserted");
    }
}
