package Util;

import Model.BankAccount;
import Model.Branch;
import Model.Customer3;
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

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(Customer3.class).addAnnotatedClass(BankAccount.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Branch b1=new Branch("Pune","HDFC0Pune");
        Customer3 c1=new Customer3("Chetan","Koregaon",b1);
        BankAccount a1=new BankAccount("Chetan Wagaskar1","Saving",20000.00,c1);
        BankAccount a2=new BankAccount("Chetan Wagaskar2","Current",25000.00,c1);

        tx= ses.beginTransaction();
        ses.save(a1);
        ses.save(a2);
        tx.commit();
        ses.close();
        System.out.println("Data Inserted");
    }
}
