package Util1;

import Model1.Car;
import Model1.ElectricCar;
import Model1.PetrolCar;
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

        cfg=new Configuration().configure().addAnnotatedClass(Car.class).addAnnotatedClass(PetrolCar.class).addAnnotatedClass(ElectricCar.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        PetrolCar p1=new PetrolCar("Verna",340000,"Petrol Engine","1 Year");
        ElectricCar e1=new ElectricCar("Swift",45000,"Electric Car","2 Year");

        tx= ses.beginTransaction();
        ses.save(p1);
        ses.save(e1);
        tx.commit();
        ses.close();
        System.out.println("Data Added");
    }
}
