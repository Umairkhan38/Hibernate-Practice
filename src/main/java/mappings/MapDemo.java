package mappings;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;


public class MapDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();


        //creating a question
        Question q1 = new Question();
        q1.setQuestionId(121);
        q1.setQuestion("What is Reactjs?");


        //creating an Answer
        Answer ans1 = new Answer();
        ans1.setAnswerId(343);
        ans1.setAnswer("Reactjs is a Javascript Library!");
        ans1.setQuestion(q1);

        //creating an Answer
        Answer ans2 = new Answer();
        ans2.setAnswerId(353);
        ans2.setAnswer("ReactJs is a js Library used for Building SinglePage App!");
        ans2.setQuestion(q1);


        List<Answer>list  = new ArrayList<Answer>();
        list.add(ans1);
        list.add(ans2);
        q1.setAnswers(list);



        //session
        Session s = factory.openSession();
        Transaction txn = s.beginTransaction();

        s.save(q1);
//        s.save(q2);

        s.save(ans1);
        s.save(ans2);

        txn.commit();

        //fetching data
//        Question fetchQ = (Question) s.get(Question.class,121);
//        System.out.println(fetchQ.getQuestion());
//        System.out.println(fetchQ.getAnswer().getAnswer());

        //incase of lazy loading it will load data related to questions
        // wont Load Answer data until get getAnswer is called
        //where eager loading load answer data from database
        //only when the getAnswer or getAnswer().size is called

        Question q = (Question)s.get(Question.class, 121);

//        System.out.println("q.getAnswers() is "+q.getAnswers());
//        for(Answer as : q.getAnswers()){
//            System.out.println(as.getAnswer());
//        }


        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());

//
//        System.out.println(q.getAnswers().size());

        s.close();
        factory.close();

    }

}
