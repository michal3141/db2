package edu.agh.iisg.db.tuning.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.agh.iisg.db.tuning.holder.Holder;
import edu.agh.iisg.db.tuning.model.Supplier;

public class SupplierParser {
	private static Supplier supplier = null;
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
					if (qName.equals("supplier")) {
						supplier = new Supplier();
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
					if (qName.equals("supplier")) {
						Holder.Suppliers.put(supplier.getSupplierID(), supplier);
					} else if (qName.equals("SupplierID")) {
						supplier.setSupplierID(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("CompanyName")) {
						supplier.setCompanyName(accum.toString().trim());
					} else if (qName.equals("Phone")) {
						supplier.setPhone(accum.toString().trim());
					} else if (qName.equals("ContactName")) {
						supplier.setContactName(accum.toString().trim());
					} else if (qName.equals("ContactTitle")) {
						supplier.setContactTitle(accum.toString().trim());
					} else if (qName.equals("Address")) {
						supplier.setAddress(accum.toString().trim());
					} else if (qName.equals("City")) {
						supplier.setCity(accum.toString().trim());
					} else if (qName.equals("PostalCode")) {
						supplier.setPostalCode(accum.toString().trim());
					} else if (qName.equals("Country")) {
						supplier.setCountry(accum.toString().trim());
					}
 				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
