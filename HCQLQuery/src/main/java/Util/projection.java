package Util;

import Model.Student;
import com.google.protobuf.DurationOrBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import java.util.Iterator;
import java.util.List;

public class projection {//Projection is class
    public static void main(String[] args) {//setProjection(Projections.max,min,avg,sum,count) means projection is
        // used for to multirow function which generate a single OutPut on basis of Multiple Inputs.
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration().configure().addAnnotatedClass(Student.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt=ses.createCriteria(Student.class);
        crt.setProjection(Projections.max("sFees"));
        List<Double> data=crt.list();
        for(Double d:data)
        {
            System.out.println();
        }

//        Criteria crt1=ses.createCriteria(Student.class);
//        crt1.setProjection(Projections.count("sId"));
//        List<Long> data1=crt1.list();
//        for(Long d1:data1)
//        {
//            System.out.println(d1);
//        }

//        Criteria crt2=ses.createCriteria(Student.class);
//        crt2.setProjection(Projections.min("sName"));
//        List<String> data2=crt2.list();
//        for(String d2:data2)
//        {
//            System.out.println(d2);
//        }

//        Criteria crt3=ses.createCriteria(Student.class);
//        crt3.setProjection(Projections.sum("sFees"));
//        List<Double> data3=crt3.list();
//        for(Double d3:data3)
//        {
//            System.out.println(d3);
//        }

        Criteria crt4=ses.createCriteria(Student.class);
        crt4.setProjection(Projections.avg("sFees"));
        List<Double> data4=crt4.list();
        Iterator<Double> itr=data4.listIterator();
        for(Double d4:data4)
        {
            System.out.println(d4);
        }
        if(itr.hasNext())
        {
            System.out.println(itr.next());
        }

//        Criteria crt5=ses.createCriteria(Student.class);
//        crt5.setProjection(Projections.countDistinct("sStream"));
//        List<Long> data5=crt5.list();
//        for(Long d5:data5)
//        {
//            System.out.println(d5);
//        }
//
//        Criteria crt6=ses.createCriteria(Student.class);
//        crt6.setProjection(Projections.rowCount());
//        List<Integer> data6=crt6.list();
//        for(Integer d6:data6)
//        {
//            System.out.println(d6);
//        }
//        Iterator<Integer> itr1= data6.iterator();
//        if(itr1.hasNext())
//        {
//            System.out.println(itr1.next());
//        }

//        Criteria crt7=ses.createCriteria(Student.class);
//        crt7.setProjection(Projections.distinct(Projections.countDistinct("sStream")));
//        List<String> data7=crt7.list();
//        for(String d7:data7)
//        {
//            System.out.println(d7);
//        }
    }
}
