package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        //creating object for question
        Question q1 = new Question();
        q1.setQuestionId(111);
        q1.setQuestion("What is java?");
        
        //creating answer object
        Answer answer = new Answer();
        answer.setAnswerId(1009);
        answer.setQuestion(q1);
        answer.setAnswer("Programming Language");
        q1.setAnswer(answer);
        
        //saving to database
        Transaction transaction = session.beginTransaction();
        session.save(answer);
        session.save(q1);
        transaction.commit();
        
        
        //fetching data
        Question q = (Question) session.get(Question.class, 111);
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswer().getAnswer());
        
        session.close();
        factory.close();
	}
}
