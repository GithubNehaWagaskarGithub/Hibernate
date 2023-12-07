package Util;

import Model.ContractEmp;
import Model.Employee1;
import Model.PermanentEmp;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayData {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration().configure().addAnnotatedClass(Employee1.class).addAnnotatedClass(ContractEmp.class).addAnnotatedClass(PermanentEmp.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

//        Criteria crt=ses.createCriteria(ContractEmp.class);
//        List<ContractEmp> data=crt.list();
//        for(ContractEmp d:data)
//        {
//            System.out.println(d.geteId()+"\t"+d.geteName()+"\t"+d.geteSal()+"\t"+d.getConDesi()+"\t"+d.getTimeDuration());
//        }

        Criteria crt1 = ses.createCriteria(PermanentEmp.class);
        List<PermanentEmp> data1 = crt1.list();
        for (PermanentEmp d1 : data1)
        {
            System.out.println(d1.geteId()+"\t"+d1.getClass()+"\t"+d1.geteSal()+"\t"+d1.getPfNo()+"\t"+d1.getPerDesi());
        }
    }
}
