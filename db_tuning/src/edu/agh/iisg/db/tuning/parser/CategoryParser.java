package edu.agh.iisg.db.tuning.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.agh.iisg.db.tuning.holder.Holder;
import edu.agh.iisg.db.tuning.model.Category;

public class CategoryParser {
	private static Category category = null;
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
					if (qName.equals("category")) {
						category = new Category();
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
					if (qName.equals("category")) {
						Holder.Categories.put(category.getCategoryID(), category);
					} else if (qName.equals("CategoryID")) {
						category.setCategoryID(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("CategoryName")) {
						category.setCategoryName(accum.toString().trim());
					} else if (qName.equals("Description")) {
						category.setDescription(accum.toString().trim());
					}
 				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
