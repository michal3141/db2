package edu.agh.iisg.db.tuning.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.agh.iisg.db.tuning.holder.Holder;
import edu.agh.iisg.db.tuning.model.Customer;

public class CustomerParser {
	private static Customer customer = null;
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
					if (qName.equals("customer")) {
						customer = new Customer();
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
					if (qName.equals("customer")) {
						Holder.Customers.put(customer.getCustomerID(), customer);
					} else if (qName.equals("CustomerID")) {
						customer.setCustomerID(accum.toString().trim());
					} else if (qName.equals("CompanyName")) {
						customer.setCompanyName(accum.toString().trim());
					} else if (qName.equals("Phone")) {
						customer.setPhone(accum.toString().trim());
					} else if (qName.equals("ContactName")) {
						customer.setContactName(accum.toString().trim());
					} else if (qName.equals("ContactTitle")) {
						customer.setContactTitle(accum.toString().trim());
					} else if (qName.equals("Address")) {
						customer.setAddress(accum.toString().trim());
					} else if (qName.equals("City")) {
						customer.setCity(accum.toString().trim());
					} else if (qName.equals("PostalCode")) {
						customer.setPostalCode(accum.toString().trim());
					} else if (qName.equals("Country")) {
						customer.setCountry(accum.toString().trim());
					} else if (qName.equals("Fax")) {
						customer.setFax(accum.toString().trim());
					}
 				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
