package Util;

import Model.BankAccount;
import Model.Branch;
import Model.Customer3;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Branch.class).addAnnotatedClass(Customer3.class).addAnnotatedClass(BankAccount.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Branch.class);
        List<Branch> data=crt.list();
        for(Branch b:data)
        {
            System.out.println(b.getbId()+"\t"+b.getbAdd());
            List<Customer3> data1=b.getCustomer3List();
            for(Customer3 c:data1)
            {
                System.out.println(c.getcId()+"\t"+c.getcName()+"\t"+c.getcCity());
                List<BankAccount> data2=c.getBankAccountList();
                for(BankAccount a:data2)
                {
                    System.out.println(a.getBaNo()+"\t"+a.getBaName()+"\t"+a.getBaType()+"\t"+a.getBaBalance());
                }
            }
        }
    }
}
