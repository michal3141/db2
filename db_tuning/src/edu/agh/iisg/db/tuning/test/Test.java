package edu.agh.iisg.db.tuning.test;

import edu.agh.iisg.db.tuning.parser.CategoryParser;
import edu.agh.iisg.db.tuning.parser.CustomerParser;
import edu.agh.iisg.db.tuning.parser.EmployeeParser;
import edu.agh.iisg.db.tuning.parser.OrderDetailsParser;
import edu.agh.iisg.db.tuning.parser.OrderParser;
import edu.agh.iisg.db.tuning.parser.ProductParser;
import edu.agh.iisg.db.tuning.parser.ShipperParser;
import edu.agh.iisg.db.tuning.parser.SupplierParser;

public class Test {
	public static void main(String[] args) {
		CustomerParser.parse("data/customers.xml");
		EmployeeParser.parse("data/employees.xml");
		CategoryParser.parse("data/categories.xml");
		SupplierParser.parse("data/suppliers.xml");
		ShipperParser.parse("data/shippers.xml");
		ProductParser.parse("data/products.xml");
		OrderParser.parse("data/orders_rand_10000.xml");
		OrderParser.parse("data/orders_rand_20000.xml");
		OrderDetailsParser.parse("data/orderdetails_rand_10000.xml");
		OrderDetailsParser.parse("data/orderdetails_rand_20000.xml");
		System.out.println("Parsed gracefully with JAVA SAX.");
		DummyPrinter.printDummy();
		Persistor.save();
		
	}
}
