package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedClass {


    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        //student1
        Student st1 = new Student();
        st1.setId(15);
        st1.setName("Ronnie Coleman");
        st1.setCity("America");

        Certificate ct = new Certificate();
        ct.setCourse("Hibernate & SpringBoot");
        ct.setDuration("2Months");
        st1.setCerti(ct);

        //student2
        Student st2 = new Student();
        st2.setId(165);
        st2.setName("Jay Cutler");
        st2.setCity("California");

        Certificate ct1 = new Certificate();
        ct1.setCourse("MERN Stack");
        ct1.setDuration("3Months");
        st2.setCerti(ct1);



        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();


        //saving a data objects
         s.save(st1);
         s.save(st2);


        tx.commit();
        s.close();
        factory.close();

    }

}
