package edu.agh.iisg.db.tuning.test.queries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestQuery6 {
	// 2.6	Jaka by³a œrednia wartoœæ sztuki produktu dla ka¿dego ze spedytorów w ka¿dym roku
	public static void main(String[] args) {
		Iterator it;
		long before = 0;
		long after = 0;
		long diff = 0;
		System.out.println("Testing query6...");
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		before = System.currentTimeMillis();
		List results = session.createSQLQuery("select s.CompanyName, date_part('year', o.ShippedDate), sum(od.UnitPrice * od.Quantity) / sum(od.Quantity) from shippers s join orders o on s.ShipperID = o.ShipVia join orderdetails od on o.OrderID = od.OrderID group by 1,2").list();
		after = System.currentTimeMillis();
		diff = after - before;
		System.out.println("Query executed in: " + diff + " milliseconds");
		
		it = results.iterator();
		while (it.hasNext()) {
			Object[] objs = (Object[]) it.next();
			System.out.println(objs[0] + ": " + Math.round((double)objs[1]) + ": " + objs[2]);
		}
		session.getTransaction().commit();
	}
}
