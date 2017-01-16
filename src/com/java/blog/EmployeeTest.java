package com.java.blog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.java.entity.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		getSession();
	}

	private static void getSession() {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        save(session);
        tx.commit();
        session.close();
        factory.close();
	}

	private static void save(Session session) {
		saveEmployee(session);
	}

	private static void saveEmployee(Session session) {
		Employee employee = ManageEmployee.getEmployee();
        session.save(employee);
        System.out.println("Object saved successfully.....!!");
	}
}
