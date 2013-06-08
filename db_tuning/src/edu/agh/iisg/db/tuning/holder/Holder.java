package edu.agh.iisg.db.tuning.holder;

import java.util.HashMap;
import java.util.Map;

import edu.agh.iisg.db.tuning.model.Category;
import edu.agh.iisg.db.tuning.model.Customer;
import edu.agh.iisg.db.tuning.model.Employee;
import edu.agh.iisg.db.tuning.model.Order;
import edu.agh.iisg.db.tuning.model.OrderDetails;
import edu.agh.iisg.db.tuning.model.Product;
import edu.agh.iisg.db.tuning.model.Shipper;
import edu.agh.iisg.db.tuning.model.Supplier;

/**
 * This is class mainly for holding purposes - hope memory will be happy with it...
 * @author Micha³
 *
 */
public class Holder {
	public static Map<String, Customer> Customers = new HashMap<>();
	public static Map<Integer, Employee> Employees = new HashMap<>();
	public static Map<Integer, Category> Categories = new HashMap<>();
	public static Map<Integer, OrderDetails> OrderDetails = new HashMap<>();
	public static Map<Integer, Order> Orders = new HashMap<>();
	public static Map<Integer, Product> Products = new HashMap<>();
	public static Map<Integer, Shipper> Shippers = new HashMap<>();
	public static Map<Integer, Supplier> Suppliers = new HashMap<>();
}
