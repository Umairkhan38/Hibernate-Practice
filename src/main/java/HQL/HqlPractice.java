package HQL;

import antlr.debug.TraceAdapter;
import org.example.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.transaction.Synchronization;
import java.util.Arrays;
import java.util.List;

public class HqlPractice {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        //creating a session
        Session s = factory.openSession();
        //HQL Syntax
        //Hql query for fetching data from table using where clause

        //passing cityName statically in HQL
        //String query = "from Student where city='California'";

        //Passing CityName Dynamically in HQL
        String query = "from Student where city=:x and name=:y";
        Query q = s.createQuery(query);


        q.setParameter("x","California");
        q.setParameter("y","Ronnie Coleman");


        //if Unique result (Single not multiple)

        //if multiple results in a form of list
        List<Student> l = q.list();

        for(Student std : l){
            System.out.println("Studnet Name is "+std.getName());
        }

        //for delettion and updation we need to begin transaction

        Transaction txn = s.beginTransaction();

        //Deleting data using HQL
//        Query q2 = s.createQuery("delete from Student s where s.city=:d");
//        q2.setParameter("d","California");
//
//        int r = q2.executeUpdate();
//        System.out.println("Deleted");
//        System.out.println(r);

        //Update Query
//        Query q3 = s.createQuery("update Student set city=:c where name=:n");
//
//        q3.setParameter("c","Mumbai");
//        q3.setParameter("n","Ronnie Coleman");
//
//        int u = q3.executeUpdate();
//        System.out.println("Rows Updated");
//        System.out.println(u);

        txn.commit();

        //join Column
        //its fetch related work then we define it after txn.commit()
        Query q4 = s.createQuery("select  q.questionId, q.question, a.answer from Question as q INNER JOIN q.answers as a");


        List <Object[]> list3 = q4.getResultList();

        for(Object[]arr : list3){
            System.out.println(Arrays.toString(arr));
        }

        s.close();
        factory.close();
    }

}
