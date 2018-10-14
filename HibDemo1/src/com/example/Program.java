package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {

	public static void main(String[] args) {
		//1. load the configuration file (hibernate.cfg.xml file)
		Configuration cfg=new Configuration().configure();
		
		//2. create sessionfactory for creating session
		SessionFactory sf=cfg.buildSessionFactory();
		
		//3. create new session from sessionfactory
		Session ss=sf.openSession();
		
		//4. close the session
		ss.close();
		
		//5. close the factory
		sf.close();
		
		
		System.out.println("done");
		
	}

}
