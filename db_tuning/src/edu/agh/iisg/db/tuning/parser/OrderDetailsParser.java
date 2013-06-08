package edu.agh.iisg.db.tuning.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.agh.iisg.db.tuning.holder.Holder;
import edu.agh.iisg.db.tuning.model.OrderDetails;

public class OrderDetailsParser {
	private static OrderDetails od = null;
	private static StringBuffer accum = new StringBuffer();
	
	public static void parse(String path) {
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(path, new DefaultHandler() {

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					super.startElement(uri, localName, qName, attributes);
					
					accum.setLength(0);
					if (qName.equals("orderdetail")) {
						od = new OrderDetails();
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
					if (qName.equals("orderdetail")) {
						Holder.OrderDetails.put(od.getOdID(), od);
					} else if (qName.equals("odID")) {
						od.setOdID(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("OrderID")) {
						od.setOrder(Holder.Orders.get(Integer.parseInt(accum.toString().trim())));
						Holder.Orders.get(Integer.parseInt(accum.toString().trim())).getOrderDetailss().add(od);
					} else if (qName.equals("ProductID")) {
						od.setProduct(Holder.Products.get(Integer.parseInt(accum.toString().trim())));
						Holder.Products.get(Integer.parseInt(accum.toString().trim())).getOrderDetailss().add(od);
					} else if (qName.equals("UnitPrice")) {
						od.setUnitPrice(Float.parseFloat(accum.toString().trim()));
					} else if (qName.equals("Quantity")) {
						od.setQuantity(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("Discount")) {
						od.setDiscount(Float.parseFloat(accum.toString().trim()));
					}
 				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
