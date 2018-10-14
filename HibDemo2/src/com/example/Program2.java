package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Program2 {

	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure("kali.cfg.xml");
		
		ServiceRegistry sr=new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties())
				.build();
		
		SessionFactory sf=cfg.buildSessionFactory(sr);
		
		Session ss=sf.openSession();
		
		ss.beginTransaction();
		
		ss.save(new Employee(111, "Rahul Verma", "Faridabad", 30000));
		
		ss.getTransaction().commit();
		
		ss.close();
		sf.close();
	}

}
