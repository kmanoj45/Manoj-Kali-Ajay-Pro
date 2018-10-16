import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojo.Employee;

public class Program2 {

	public static void main(String[] args) {
		SessionFactory sf=Program.getFactory();
		
		Session ss=sf.openSession();
		
		Employee emp=(Employee)ss.get(Employee.class, 102);
				
		System.out.println("Name "+emp.getName());
		System.out.println("DOB "+emp.getDob());
		ss.close();
		sf.close();
	}

}
