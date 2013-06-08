package edu.agh.iisg.db.tuning.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.agh.iisg.db.tuning.holder.Holder;

public class Persistor {
	
	private static SessionFactory sessionFactory;
	public static void save() {
		int counter = 0;
		long beforeGlobal = 0;
		long afterGlobal = 0;
		long diffGlobal = 0;
		long before = 0;
		long after = 0;
		long diff = 0;
		setUp();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		loadWithoutOrders(session);
		System.out.println("Starting to load orders and orderdetails");
		beforeGlobal = System.currentTimeMillis();
		before = System.currentTimeMillis();
		
		for (Integer i : Holder.Orders.keySet()) {
			counter++;
			if (counter % 1000 == 0) {
				after = System.currentTimeMillis();
				diff = after - before;
				System.out.println((counter / 1000) + ": " + (1000000.0 / diff) + " orders per second.");
				before = System.currentTimeMillis();
			}
			session.save(Holder.Orders.get(i));
		}
		// Comment this loop and add CascadeType.ALL to get cascade saving
		for (Integer i : Holder.OrderDetails.keySet()) {
			session.save(Holder.OrderDetails.get(i));
		}
		System.out.println("Before commit...");
		
		session.getTransaction().commit();
		afterGlobal = System.currentTimeMillis();
		diffGlobal = afterGlobal - beforeGlobal;
		System.out.println("Operation took: " + diffGlobal + " millisecods to complete.");
	}

	/**
	 * Populating database with things not including orders and orderdetails
	 * @param session
	 */
	private static void loadWithoutOrders(Session session) {
		for (String s : Holder.Customers.keySet()) {
			session.save(Holder.Customers.get(s));
		}
		
		for (Integer i : Holder.Employees.keySet()) {
			session.save(Holder.Employees.get(i));
		}
		
		for (Integer i : Holder.Categories.keySet()) {
			session.save(Holder.Categories.get(i));
		}
		
		for (Integer i : Holder.Suppliers.keySet()) {
			session.save(Holder.Suppliers.get(i));
		}
		
		for (Integer i : Holder.Shippers.keySet()) {
			session.save(Holder.Shippers.get(i));
		}
		
		for (Integer i : Holder.Products.keySet()) {
			session.save(Holder.Products.get(i));
		}
	}
	
	private static void setUp() {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
	}
}
