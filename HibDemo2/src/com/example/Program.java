package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Program {

	public static void main(String[] args) {
		//load the named configuration file
		Configuration cfg=new Configuration().configure("kali.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session ss=sf.openSession();
		
		Transaction tx=ss.beginTransaction();
		
		ss.save(new Employee(102,"Rajiv Kumar","New Delhi",30000));
		ss.save(new Employee(103,"Anil Kumar","New Delhi",35000));
		ss.save(new Employee(104,"Sunil Kumar","Noida",20000));
		ss.save(new Employee(105,"Arjun Kumar","New Delhi",55000));
		ss.save(new Employee(106,"Rajan Kumar","Noida",25000));
		
		tx.commit();
		ss.close();
		sf.close();
		
		System.out.println("Now done..");
	}

}
