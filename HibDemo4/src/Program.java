import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.pojo.Employee;

public class Program {

	public static void main(String[] args) {
		SessionFactory sf=getFactory();
		Session ss=sf.openSession();
		
		Calendar cal=Calendar.getInstance();
		cal.set(1994, 10, 3);
		Date dob=cal.getTime();
		
		Employee emp=new Employee(103, "Manoj Kumar", "New Delhi", dob);
		ss.beginTransaction();
		
		ss.save(emp);
		
		ss.getTransaction().commit();
		ss.close();
		sf.close();
		System.out.println("Done..");
	}
	
	public static SessionFactory getFactory() {
		
		Configuration cfg=new Configuration();
		cfg.addAnnotatedClass(Employee.class);
		cfg.setProperty(Environment.DRIVER,"com.mysql.jdbc.Driver" );
		cfg.setProperty(Environment.URL, "jdbc:mysql://localhost/manojdb");
		cfg.setProperty(Environment.USER, "root");
		cfg.setProperty(Environment.PASS, "");
		cfg.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		cfg.setProperty(Environment.HBM2DDL_AUTO, "update");
		cfg.setProperty(Environment.SHOW_SQL, "true");
		cfg.setProperty(Environment.FORMAT_SQL, "true");
		
		
		ServiceRegistry sr=new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties())
				.build();
		
		SessionFactory sf=cfg.buildSessionFactory(sr);
		
		return sf;
	}

}
