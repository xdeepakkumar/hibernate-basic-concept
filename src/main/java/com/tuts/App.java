package com.tuts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Application started.." );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(101);
        st.setName("Deepak Kumar");
        st.setCity("Delhi");
        
        //creating object for the address
        Address ad = new Address();
        ad.setStreet("Alaula");
        ad.setCity("Kalyanpur");
        ad.setIsOpen(true);
        ad.setAddedDate(new Date());
        //image setup
        FileInputStream fileInputStream = new FileInputStream("src/main/java/user.jpg");
        byte[] img_data = new byte[fileInputStream.available()];
        fileInputStream.read(img_data);
        ad.setImage(img_data);
        
        //creating session object
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(st);
        session.save(ad);
        transaction.commit();
        session.close();    
        System.out.println("All done...");
        
        
    }
}
