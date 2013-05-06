package edu.agh.iisg.db.test;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.agh.iisg.db.dto.Person;

public class HelloHibernate {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		
		// Creating some objects
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for (int i = 1; i <= 10; i++) {
			Person p = new Person();
			p.setName("Name" + i);
			p.setSurname("Surname" + i);
			p.setDateOfBirth(new GregorianCalendar());
			session.save(p);
		}
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Obtaining person object
		Person p = (Person) session.get(Person.class, 3);
		System.out.println(p.toString());
		
		// Updating name (without explicit call to update!)
		p.setName("John");
		
		// Obtaining another object
		Person p2 = (Person) session.get(Person.class, 5);
		// Deleting obtained person from database
		session.delete(p2);
		
		session.getTransaction().commit();
		session.close();
	}
}
