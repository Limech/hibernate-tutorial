package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static
	{
		try
		{
			Configuration configuration = new Configuration().configure();
		    StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		    
		    serviceRegistryBuilder.applySettings(configuration.getProperties());
		    
		    serviceRegistry = serviceRegistryBuilder.build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		}
		catch(HibernateException exception)
		{
			System.out.println("Problem creating session factory!");
			System.out.println(exception.getMessage());
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
}
