package edu.agh.iisg.db.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.agh.iisg.db.dto.Customer;
import edu.agh.iisg.db.dto.Product;

public class RelationsCriteriaHQLazy {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());

		// Creating new consumer object with products
		Customer c = new Customer();
		c.setName("John");
		c.populateWithSomeProducts();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Note that without Cascade you need to save all products independently of customer as well...
		session.save(c);

		session.getTransaction().commit();
		session.close();
		
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		// Using Criteria API to obtain list of products from category: Fruit
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("category", "Fruit"));
		List<Product> products = (ArrayList<Product>) criteria.list();
		
		// Using HQL (Hibernate Query Language) to fetch Customer
		Query hql = session.createQuery("from Customer");
		List<Customer> customers = (ArrayList<Customer>) hql.list();
		Customer hqlCustomer = customers.get(0);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("List of products with Fruit category:");
		for (Product p : products) {
			System.out.println(p.toString());
		}
		
		System.out.println("Products of customer obtained by using HQL:");
		for (Product p : hqlCustomer.getProducts()) {
			System.out.println(p.toString());
		}
		
	}
}
