package com.tuts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application started.." );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(101);
        st.setName("Deepak Kumar");
        st.setCity("Delhi");
        
        //creating session object
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(st);
        transaction.commit();
        session.close();        
    }
}
