package com.map;

import java.util.ArrayList;
import java.util.List;

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
        
        Answer answer2 = new Answer();
        answer2.setAnswerId(1010);
        answer2.setQuestion(q1);
        answer2.setAnswer("OOPs Programming Language");
        
        Answer answer3 = new Answer();
        answer3.setAnswerId(1011);
        answer3.setQuestion(q1);
        answer3.setAnswer("Titely Coupled Language");
        
        List<Answer> list = new ArrayList<Answer>();
        list.add(answer);
        list.add(answer2);
        list.add(answer3);
        
        q1.setAnswers(list);
        
        
        //saving to database
        Transaction transaction = session.beginTransaction();
        session.save(answer);
        session.save(answer2);
        session.save(answer3);
        session.save(q1);
        transaction.commit();
        
        
        //fetching data
        Question q = (Question) session.get(Question.class, 111);
        System.out.println(q.getQuestion());
        for (Answer a : q.getAnswers()) {
			System.out.println(a.getAnswer());
		}
        
        
        session.close();
        factory.close();
	}
}
