package com.java.blog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.java.entity.Login;

public class ManageLogin {

	public static Login manageLogin(String userName, String password) {
		Login login = new Login();
	    login.setUserName(userName);
	    login.setPassword(password);
	    
	    return login;
	}
	
	public static void getSession(Login login) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        System.out.println("username : "+login.getUserName());
		System.out.println("password : "+login.getPassword());
        
        session.save(login);
        tx.commit();
        session.close();
        factory.close();
	}

}
