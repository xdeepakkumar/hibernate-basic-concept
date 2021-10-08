package com.tuts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        //get function
        Student student = session.get(Student.class, 101);
        System.out.println(student);
	}

}
