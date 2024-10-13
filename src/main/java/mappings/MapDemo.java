package mappings;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


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
        q1.setAnswer(ans1);
        ans1.setQuestion(q1);

        //creating a question
        Question q2 = new Question();
        q2.setQuestionId(221);
        q2.setQuestion("What is Nodejs?");

        //creating an Answer
        Answer ans2 = new Answer();
        ans2.setAnswerId(353);
        ans2.setAnswer("Nodejs is a Javascript Runtime Enviroment!");
        q2.setAnswer(ans2);
        ans2.setQuestion(q2);



        //session
        Session s = factory.openSession();
        Transaction txn = s.beginTransaction();

        s.save(q1);
        s.save(q2);

        s.save(ans1);
        s.save(ans2);

        txn.commit();

        //fetching data
        Question fetchQ = (Question) s.get(Question.class,121);
        System.out.println(fetchQ.getQuestion());
        System.out.println(fetchQ.getAnswer().getAnswer());

        s.close();
        factory.close();

    }

}
