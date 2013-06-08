package edu.agh.iisg.db.tuning.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="suppliers")
public class Supplier {

	@Id
	private Integer SupplierID;
	
	private String CompanyName;
	
	private String ContactName;
	
	private String ContactTitle;
	
	private String Address;
	
	private String City;
	
	private String PostalCode;
	
	private String Country;
	
	private String Phone;
	
	@OneToMany(mappedBy="Supplier")
	private Set<Product> Products = new HashSet<Product>();

	public Supplier() {};
	public Supplier(Integer supplierID, String companyName, String contactName,
			String contactTitle, String address, String city,
			String postalCode, String country, String phone) {
		super();
		SupplierID = supplierID;
		CompanyName = companyName;
		ContactName = contactName;
		ContactTitle = contactTitle;
		Address = address;
		City = city;
		PostalCode = postalCode;
		Country = country;
		Phone = phone;
	}

	public Integer getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(Integer supplierID) {
		SupplierID = supplierID;
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

	public Set<Product> getProducts() {
		return Products;
	}

	public void setProducts(Set<Product> products) {
		Products = products;
	}
	
}
