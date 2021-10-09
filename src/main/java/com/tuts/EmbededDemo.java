package com.tuts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbededDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(102);
		student1.setName("Suraj Kumar");
		student1.setCity("Alaula");
		
		//now creating the object of certificate for setup
		Certificate certificate = new Certificate();
		certificate.setCourse("MCA");
		certificate.setDuration("3 YEAR");
		
		student1.setCerti(certificate);
		
		//now adding to db with session
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//saving the object
		session.save(student1);
		
		
		transaction.commit();
		factory.close();
	}

}
