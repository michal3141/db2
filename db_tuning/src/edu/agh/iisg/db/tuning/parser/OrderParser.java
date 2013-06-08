package edu.agh.iisg.db.tuning.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.agh.iisg.db.tuning.holder.Holder;
import edu.agh.iisg.db.tuning.model.Order;

public class OrderParser {
	private static Order order = null;
	private static StringBuffer accum = new StringBuffer();
	
	public static void parse(String path) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(path, new DefaultHandler() {

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					super.startElement(uri, localName, qName, attributes);
					
					accum.setLength(0);
					if (qName.equals("order")) {
						order = new Order();
					} 
				}
				
				@Override
				public void characters(char[] ch, int start, int length)
						throws SAXException {
					super.characters(ch, start, length);
					accum.append(ch, start, length);
				}

				@Override
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					super.endElement(uri, localName, qName);
					if (qName.equals("order")) {
						Holder.Orders.put(order.getOrderID(), order);
					} else if (qName.equals("OrderID")) {
						order.setOrderID(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("CustomerID")) {
						order.setCustomer(Holder.Customers.get(accum.toString().trim()));
						Holder.Customers.get(accum.toString().trim()).getOrders().add(order);
					} else if (qName.equals("EmployeeID")) {
						order.setEmployee(Holder.Employees.get(Integer.parseInt(accum.toString().trim())));
						Holder.Employees.get(Integer.parseInt(accum.toString().trim())).getOrders().add(order);
					} else if (qName.equals("OrderDate")) {
						try {
							order.setOrderDate(sdf.parse(accum.toString().trim()));
						} catch (ParseException e) {
							System.out.println("Invalid date");
							e.printStackTrace();
						}
					} else if (qName.equals("RequiredDate")) {
						try {
							order.setRequiredDate(sdf.parse(accum.toString().trim()));
						} catch (ParseException e) {
							System.out.println("Invalid date");
							e.printStackTrace();
						}
					} else if (qName.equals("ShippedDate")) {
						try {
							order.setShippedDate(sdf.parse(accum.toString().trim()));
						} catch (ParseException e) {
							System.out.println("Invalid date");
							e.printStackTrace();
						}
					} else if (qName.equals("ShipVia")) {
						order.setShipVia(Holder.Shippers.get(Integer.parseInt(accum.toString().trim())));
						Holder.Shippers.get(Integer.parseInt(accum.toString().trim())).getOrders().add(order);
					} else if (qName.equals("Freight")) {
						order.setFreight(Float.parseFloat(accum.toString().trim()));
					} else if (qName.equals("ShipName")) {
						order.setShipName(accum.toString().trim());
					} else if (qName.equals("ShipAddress")) {
						order.setShipAddress(accum.toString().trim());
					} else if (qName.equals("ShipCity")) {
						order.setShipCity(accum.toString().trim());
					} else if (qName.equals("ShipPostalCode")) {
						order.setShipPostalCode(accum.toString().trim());
					} else if (qName.equals("ShipCountry")) {
						order.setShipCountry(accum.toString().trim());
					}
 				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
