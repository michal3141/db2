package edu.agh.iisg.db.tuning.test.queries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestQuery1 {
	//ile zamówieñ z ka¿dego kraju zosta³o zrealizowanych
	public static void main(String[] args) {
		Iterator it;
		long before = 0;
		long after = 0;
		long diff = 0;
		System.out.println("Testing query1...");
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		before = System.currentTimeMillis();
		List results = session.createSQLQuery("select c.country, count(o.orderID) from orders o join customers c " +
											  "on c.customerID=o.customerID group by c.country" ).list();
		after = System.currentTimeMillis();
		diff = after - before;
		System.out.println("Query executed in: " + diff + " milliseconds");
		
		it = results.iterator();
		while (it.hasNext()) {
			Object[] objs = (Object[]) it.next();
			System.out.println(objs[0] + ": " + objs[1]);
		}
		session.getTransaction().commit();
	}
}
