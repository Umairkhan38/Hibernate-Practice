package org.example;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.*;


public class FetchDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session s = factory.openSession();


        //get data by id 8
        Student std = (Student)s.get(Student.class,8);
        System.out.println("The get Data of Student is "+std);

        //Load data by id
        //load function returns a proxy object [copy of real obj] but not contain data
        //data obtained by calling particular function using object
        Address ad = (Address)s.load(Address.class,1);
        System.out.println("The get Data of Address Street is "+ad.getStreet()+" CITY is "+ad.getCity());



        s.close();
        factory.close();
    }

}
