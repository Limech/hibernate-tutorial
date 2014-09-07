package hibernate;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
		//try {
			//Class.forName("org.h2.Driver");
			

			Session session = HibernateUtilities.getSessionFactory().openSession();
			
			session.close();
			
		//} catch (ClassNotFoundException e) {
	//		e.printStackTrace();
	//	}
		System.out.println("Hello World");
	}
}
