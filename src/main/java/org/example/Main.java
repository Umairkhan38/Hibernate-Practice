package org.example;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Student st = new Student();
        st.setId(8);
        st.setName("Jhon Doe");
        st.setCity("NewYork");
        System.out.println(st);

        Student st1 = new Student();
        st1.setId(10);
        st1.setName("Ronnie Coleman");
        st1.setCity("California");
        System.out.println(st);

        //creating object for a student address
        Address ad = new Address();
        ad.setStreet("Street1");
        ad.setCity("Mumbai");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(321.456);

        //File Input Stream
        FileInputStream fip = new FileInputStream("C://Users/Khan Umair/IdeaProjects/HibernatePractice/src/dashboard.PNG");
        byte data []=new byte[fip.available()];
        fip.read(data);
        ad.setImage(data);


        Session s = factory.openSession();

        Transaction tx = s.beginTransaction();
        s.save(st);
        s.save(st1);
        s.save(ad);

        tx.commit();
        s.close();

        System.out.println("Done");


    }
}