package edu.agh.iisg.db.tuning.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	private String CustomerID;
	
	private String CompanyName;
	
	private String ContactName;
	
	private String ContactTitle;
	
	private String Address;
	
	private String City;
	
	private String PostalCode;
	
	private String Country;
	
	private String Phone;
	
	private String Fax;
	
	@OneToMany(mappedBy="Customer")
	private Set<Order> Orders = new HashSet<Order>();

	public Customer() {}
	public Customer(String customerID, String companyName, String contactName,
			String contactTitle, String address, String city, String postalCode,
			String country, String phone, String fax) {
		super();
		CustomerID = customerID;
		CompanyName = companyName;
		ContactName = contactName;
		ContactTitle = contactTitle;
		Address = address;
		City = city;
		PostalCode = postalCode;
		Country = country;
		Phone = phone;
		Fax = fax;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getContactName() {
		return ContactName;
	}

	public void setContactName(String contactName) {
		ContactName = contactName;
	}

	public String getContactTitle() {
		return ContactTitle;
	}

	public void setContactTitle(String contactTitle) {
		ContactTitle = contactTitle;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	public String getCity() {
		return City;
	}
	
	public void setCity(String city) {
		City = city;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public Set<Order> getOrders() {
		return Orders;
	}

	public void setOrders(Set<Order> orders) {
		Orders = orders;
	}
	
}
