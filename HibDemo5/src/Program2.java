import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Student;

public class Program2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try(SessionFactory sf=Program.getFactory();
				Session ss=sf.openSession())
		{
			Query<Student> q1 = ss.createQuery("from stds");
			
			List<Student> list= q1.getResultList();
			
			for(Student s : list) {
				System.out.println("Name " +s.getName());
				System.out.println("DOB "+s.getDob());
				System.out.println("--------------------------");
			}
			
		}
		catch(HibernateException ex) {
			System.out.println("Error "+ex.getMessage());
		}
	}

}
