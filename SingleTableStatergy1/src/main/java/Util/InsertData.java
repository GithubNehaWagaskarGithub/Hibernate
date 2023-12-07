package Util;
import Model.ContractEmp;
import Model.Employee1;
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

        cfg=new Configuration().configure().addAnnotatedClass(Employee1.class).addAnnotatedClass(ContractEmp.class).addAnnotatedClass(PermanentEmp.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        ContractEmp c1=new ContractEmp("Neha",25000,"1 year","Developer");
        PermanentEmp p1=new PermanentEmp("Ayush",35000,"Taeter",12345);
        tx=ses.beginTransaction();
        ses.save(c1);
        ses.save(p1);
        tx.commit();
        ses.close();
        factory.close();;
        System.out.println("Data Added");
    }
}
