package edu.agh.iisg.db.tuning.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.agh.iisg.db.tuning.holder.Holder;
import edu.agh.iisg.db.tuning.model.Product;

public class ProductParser {
	private static Product product = null;
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
					if (qName.equals("product")) {
						product = new Product();
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
					if (qName.equals("product")) {
						Holder.Products.put(product.getProductID(), product);
					} else if (qName.equals("ProductID")) {
						product.setProductID(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("ProductName")) {
						product.setProductName(accum.toString().trim());
					} else if (qName.equals("SupplierID")) {
						product.setSupplier(Holder.Suppliers.get(Integer.parseInt(accum.toString().trim())));
						Holder.Suppliers.get(Integer.parseInt(accum.toString().trim())).getProducts().add(product);
					} else if (qName.equals("CategoryID")) {
					    product.setCategory(Holder.Categories.get(Integer.parseInt(accum.toString().trim())));
					    Holder.Categories.get(Integer.parseInt(accum.toString().trim())).getProducts().add(product);
					} else if (qName.equals("QuantityPerUnit")) {
						product.setQuantityPerUnit(accum.toString().trim());
					} else if (qName.equals("UnitPrice")) {
						product.setUnitPrice(Float.parseFloat(accum.toString().trim()));
					} else if (qName.equals("UnitsInStock")) {
						product.setUnitsInStock(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("UnitsOnOrder")) {
						product.setUnitsOnOrder(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("ReorderLevel")) {
						product.setReorderLevel(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("Discontinued")) {
						product.setDiscontinued(Integer.parseInt(accum.toString().trim()));
					}
 				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
