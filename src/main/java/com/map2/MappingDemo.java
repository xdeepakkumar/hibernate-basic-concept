package com.map2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        Employee employee = new Employee();
        Employee employee2 = new Employee();
        
        employee.seteId(2001);
        employee.setName("Raja Sai");
        
        employee2.seteId(2002);
        employee2.setName("Raja Sai");
      
        Project project = new Project();
        Project project2 = new Project();
        project.setpId(12121);
        project.setProjectName("Library Management System");
        project2.setpId(12122);
        project2.setProjectName("Employee Management System");
        
        List<Employee> list1 = new ArrayList<Employee>();
        List<Project> list2 = new ArrayList<Project>();
        
        list1.add(employee);
        list1.add(employee2);
        list2.add(project);
        list2.add(project2);
        
        
        //adding project to employee
        employee.setProjects(list2);
        project.setEmployees(list1);
        
        Session s = factory.openSession();
        Transaction transaction = s.beginTransaction();
     
        s.save(employee);
        s.save(project2);
        s.save(project);
        s.save(project2);
        
        transaction.commit();
        
        session.close();
	}

}
