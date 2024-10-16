package ManyToMany;

import net.bytebuddy.asm.MemberSubstitution;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ProjectDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        //CREATING AN EMPLOYEES
        Emp ep1 = new Emp();
        Emp ep2 = new Emp();

        ep1.setEid(65);
        ep1.setName("Irfan");

        ep2.setEid(80);
        ep2.setName("Yusuf");


        //creating a Project
        Project p1 = new Project();
        Project p2 = new Project();

        p1.setpId(5);
        p1.setProjectName("E-Commerce");

        p2.setpId(55);
        p2.setProjectName("CRM Web Application");


        //creating list
        List<Emp>list1 = new ArrayList<Emp>();
        List<Project>list2 = new ArrayList<Project>();

        list1.add(ep1);
        list1.add(ep2);

        list2.add(p1);
        list2.add(p2);

        ep1.setProjects(list2);
        p2.setEmployees(list1);

        Session s = factory.openSession();
        Transaction txn = s.beginTransaction();

        s.save(ep1);
        s.save(ep2);

        s.save(p1);
        s.save(p2);

        txn.commit();



        s.close();
        factory.close();
    }

}
