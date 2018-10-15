import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.Product;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Product p1=(Product)session.get(Product.class, 101);
		
		if(p1==null) {
			System.out.println("Record not found");
		}else {
			System.out.println("Record found");
			System.out.println(p1);
			
			p1.setPname("Coca cola");
			p1.setPrice(55);
			
			session.update(p1);
			
			System.out.println("Record updated..");
		}
		
		tx.commit();
		
		session.close();
		sf.close();
		
		
	}

}
