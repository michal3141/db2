package edu.agh.iisg.db.tuning.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	private Integer EmployeeID;
	
	private String LastName;
	
	private String FirstName;
	
	private String Title;
	
	private String TitleOfCourtesy;
	
	@Temporal(TemporalType.DATE)
	private Date BirthDate;
	
	@Temporal(TemporalType.DATE)
	private Date HireDate;
	
	private String Address;
	
	private String City;
	
	private String Region;
	
	private String PostalCode;
	
	private String Country;
	
	private String HomePhone;
	
	private String Extension;
	
	@Column(length=1000)
	private String Notes;
	
	// TODO setup relationship between employees entities...
	private Integer ReportsTo;
	
	@OneToMany(mappedBy="Employee")
	private Set<Order> Orders = new HashSet<Order>();

	public Employee() {};
	public Employee(Integer employeeID, String lastName, String firstName,
			String title, String titleOfCourtesy, Date birthDate,
			Date hireDate, String address, String city, String region,
			String postalCode, String country, String homePhone,
			String extension, String notes, Integer reportsTo) {
		super();
		EmployeeID = employeeID;
		LastName = lastName;
		FirstName = firstName;
		Title = title;
		TitleOfCourtesy = titleOfCourtesy;
		BirthDate = birthDate;
		HireDate = hireDate;
		Address = address;
		City = city;
		Region = region;
		PostalCode = postalCode;
		Country = country;
		HomePhone = homePhone;
		Extension = extension;
		Notes = notes;
		ReportsTo = reportsTo;
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getTitleOfCourtesy() {
		return TitleOfCourtesy;
	}

	public void setTitleOfCourtesy(String titleOfCourtesy) {
		TitleOfCourtesy = titleOfCourtesy;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public Date getHireDate() {
		return HireDate;
	}

	public void setHireDate(Date hireDate) {
		HireDate = hireDate;
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

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
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

	public String getHomePhone() {
		return HomePhone;
	}

	public void setHomePhone(String homePhone) {
		HomePhone = homePhone;
	}

	public String getExtension() {
		return Extension;
	}

	public void setExtension(String extension) {
		Extension = extension;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public Integer getReportsTo() {
		return ReportsTo;
	}

	public void setReportsTo(Integer reportsTo) {
		ReportsTo = reportsTo;
	}

	public Set<Order> getOrders() {
		return Orders;
	}

	public void setOrders(Set<Order> orders) {
		Orders = orders;
	}
	
}
