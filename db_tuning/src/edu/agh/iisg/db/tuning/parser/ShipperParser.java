package edu.agh.iisg.db.tuning.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.agh.iisg.db.tuning.holder.Holder;
import edu.agh.iisg.db.tuning.model.Shipper;

/**
 * Lets parse some Shippers
 * @author Micha³
 *
 */
public class ShipperParser {
	
	private static Shipper shipper = null;
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
					if (qName.equals("shipper")) {
						shipper = new Shipper();
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
					if (qName.equals("shipper")) {
						Holder.Shippers.put(shipper.getShipperID(), shipper);
					} else if (qName.equals("ShipperID")) {
						shipper.setShipperID(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("CompanyName")) {
						shipper.setCompanyName(accum.toString().trim());
					} else if (qName.equals("Phone")) {
						shipper.setPhone(accum.toString().trim());
					}
 				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
