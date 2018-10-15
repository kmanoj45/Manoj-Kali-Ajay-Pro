import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.Product;

public class Program {

	public static void main(String[] args) {
		
		Product p1=new Product("Mirinda",50);
		
		//1.load the hibernate configuration file
		//Configuration cfg=new Configuration().configure();
		Configuration cfg=new Configuration();
		
		cfg.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		cfg.setProperty(Environment.URL, "jdbc:mysql://localhost/manojdb");
		cfg.setProperty(Environment.USER, "root");
		cfg.setProperty(Environment.PASS, "");
		cfg.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect" );
		cfg.setProperty(Environment.HBM2DDL_AUTO, "update");
		cfg.setProperty(Environment.SHOW_SQL, "true");
		cfg.setProperty(Environment.FORMAT_SQL, "true");
		
		cfg.addAnnotatedClass(Product.class);
		
		//2. Create session factory
		//SessionFactory sf=cfg.buildSessionFactory();
		ServiceRegistry sr=new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties())
				.build();
		
		SessionFactory sf=cfg.buildSessionFactory(sr);
		
		//3. Session create from factory
		Session ss=sf.openSession();
		
		Transaction tx=ss.beginTransaction();
		Object id= ss.save(p1);
		
		System.out.println("Record saved with id "+id);
		
		tx.commit();
		
		ss.close();
		sf.close();
		
		System.out.println("OK done");
	}

}
