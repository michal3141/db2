package edu.agh.iisg.db.tuning.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.agh.iisg.db.tuning.holder.Holder;
import edu.agh.iisg.db.tuning.model.Employee;

public class EmployeeParser {
	private static Employee employee = null;
	private static StringBuffer accum = new StringBuffer();
	
	public static void parse(String path) {
		try {		
			
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(path, new DefaultHandler() {

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					super.startElement(uri, localName, qName, attributes);
					
					accum.setLength(0);
					if (qName.equals("employee")) {
						employee = new Employee();
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
					if (qName.equals("employee")) {
						Holder.Employees.put(employee.getEmployeeID(), employee);
					} else if (qName.equals("EmployeeID")) {
						employee.setEmployeeID(Integer.parseInt(accum.toString().trim()));
					} else if (qName.equals("LastName")) {
						employee.setLastName(accum.toString().trim());
					} else if (qName.equals("FirstName")) {
						employee.setFirstName(accum.toString().trim());
					} else if (qName.equals("Title")) {
						employee.setTitle(accum.toString().trim());
					} else if (qName.equals("TitleOfCourtesy")) {
						employee.setTitleOfCourtesy(accum.toString().trim());
					} else if (qName.equals("BirthDate")) {
						try {
							employee.setBirthDate(sdf.parse(accum.toString().trim()));
						} catch (ParseException e) {
							System.out.println("Invalid date");
							e.printStackTrace();
						}
					} else if (qName.equals("HireDate")) {
						try {
							employee.setHireDate(sdf.parse(accum.toString().trim()));
						} catch (ParseException e) {
							System.out.println("Invalid date");
							e.printStackTrace();
						}
					} else if (qName.equals("Address")) {
						employee.setAddress(accum.toString().trim());
					} else if (qName.equals("City")) {
						employee.setCity(accum.toString().trim());
					} else if (qName.equals("Region")) {
						employee.setRegion(accum.toString().trim());
					} else if (qName.equals("PostalCode")) {
						employee.setPostalCode(accum.toString().trim());
					} else if (qName.equals("Country")) {
						employee.setCountry(accum.toString().trim());
					} else if (qName.equals("HomePhone")) {
						employee.setHomePhone(accum.toString().trim());
					} else if (qName.equals("Extension")) {
						employee.setExtension(accum.toString().trim());
					} else if (qName.equals("Notes")) {
						employee.setNotes(accum.toString().trim());
					} else if (qName.equals("ReportsTo")) {
						employee.setReportsTo(Integer.parseInt(accum.toString().trim()));
					}
 				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
