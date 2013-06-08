package edu.agh.iisg.db.tuning.test.queries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestQuery3 {
	// ile sztuk produktów od ka¿dego z dostawców uda³o siê sprzedaæ
	public static void main(String[] args) {
		Iterator it;
		long before = 0;
		long after = 0;
		long diff = 0;
		System.out.println("Testing query3...");
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		before = System.currentTimeMillis();
		List results = session.createSQLQuery("select s.CompanyName, sum(od.Quantity) from suppliers s inner join products p on s.SupplierID = p.SupplierID inner join orderdetails od on p.ProductID = od.ProductID group by s.CompanyName" ).list();
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
