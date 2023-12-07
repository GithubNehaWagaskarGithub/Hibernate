package Util;

import Model.ContractEmp;
import Model.Employee1;
import Model.PermanentEmp;
import Model1.Car;
import Model1.ElectricCar;
import Model1.PetrolCar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Employee1.class).addAnnotatedClass(ContractEmp.class).addAnnotatedClass(PermanentEmp.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Designation :");
        String desig=sc.next();
        ContractEmp c1=ses.load(ContractEmp.class,id);
        c1.setConDesi(desig);

        tx=ses.beginTransaction();
        ses.update(c1);
        tx.commit();
        ses.close();
        System.out.println("Data Updated");
    }
}
