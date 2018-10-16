import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.Student;

public class Program {

	public static void main(String[] args) {
		SessionFactory sf=getFactory();
		Session ss=sf.openSession();
		ss.beginTransaction();
		
		ss.save(new Student(102, "Ajay Kumar", "New Delhi", LocalDate.of(1994, 8, 12)));
		ss.save(new Student(103, "Manoj Kumar", "Noida", LocalDate.of(1994, 11, 3)));
		ss.save(new Student(104, "Anand Kumar", "New Delhi", LocalDate.of(1987, 11, 3)));
		ss.save(new Student(105, "Vinod Kumar", "Noida", LocalDate.of(1996, 11, 10)));
		
		ss.getTransaction().commit();
		ss.close();
		sf.close();
		System.out.println("ok done");
	}
	
	public static SessionFactory getFactory()
	{
		Configuration cfg=new Configuration();
		cfg.addAnnotatedClass(Student.class);
		cfg.setProperty(Environment.DRIVER,"com.mysql.jdbc.Driver" );
		cfg.setProperty(Environment.URL, "jdbc:mysql://localhost/manojdb");
		cfg.setProperty(Environment.USER, "root");
		cfg.setProperty(Environment.PASS, "");
		cfg.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
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
