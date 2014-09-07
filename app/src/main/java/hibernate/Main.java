package hibernate;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
		  
		System.out.println("Hello World");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
	    Plan plan = new Plan();
	    plan.setName("Joe");
	    plan.setGoal(240);
	    session.save(plan);
		session.getTransaction().commit();
		
		
		session.beginTransaction();
		Plan loadedPlan = (Plan) session.load(Plan.class, 1);
		
		System.out.println(loadedPlan.getName());
		System.out.println(loadedPlan.getGoal());
		
		loadedPlan.setTotal(loadedPlan.getTotal() + 50);
		
		session.getTransaction().commit();
		
		session.close();
        HibernateUtilities.getSessionFactory().close();
        
      
	}
}
