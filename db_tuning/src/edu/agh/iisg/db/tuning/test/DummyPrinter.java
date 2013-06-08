package edu.agh.iisg.db.tuning.test;

import edu.agh.iisg.db.tuning.holder.Holder;

/**
 * It only prints some dummy stuff from parsed data - namely: PK's
 * @author Micha³
 *
 */
public class DummyPrinter {
	public static void printDummy() {
		
		System.out.println("Printing keys for Customers...");
		for (String s : Holder.Customers.keySet()) {
			System.out.println(s);
		}
		
		System.out.println("Printing keys for Employees...");
		for (Integer i : Holder.Employees.keySet()) {
			System.out.println(i);
			System.out.println(Holder.Employees.get(i).getBirthDate());
		}
		
		System.out.println("Printing keys for Categories...");
		for (Integer i : Holder.Categories.keySet()) {
			System.out.println(i);
		}
		
		System.out.println("Printing keys for Suppliers...");
		for (Integer i : Holder.Suppliers.keySet()) {
			System.out.println(i);
		}
		
		System.out.println("Printing keys for Shippers...");
		for (Integer i : Holder.Shippers.keySet()) {
			System.out.println(i);
		}
		
		System.out.println("Printing keys for Products...");
		for (Integer i : Holder.Products.keySet()) {
			System.out.println(i);
		}
		
		System.out.println("Printing keys for Orders...");
		for (Integer i : Holder.Orders.keySet()) {
			System.out.println(i);
		}
		
		System.out.println("Printing keys for OrderDetails...");
		for (Integer i : Holder.OrderDetails.keySet()) {
			System.out.println(i);
		}
	}
}
