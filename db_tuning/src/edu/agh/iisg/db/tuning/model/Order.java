package edu.agh.iisg.db.tuning.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {

	@Id
	private Integer OrderID;
	
	@ManyToOne
	@JoinColumn(name="CustomerID")
	private Customer Customer;
	
	@ManyToOne
	@JoinColumn(name="EmployeeID")
	private Employee Employee;
	
	@ManyToOne
	@JoinColumn(name="ShipVia")
	private Shipper ShipVia;
	
	@Temporal(TemporalType.DATE)
	private Date OrderDate;
	
	@Temporal(TemporalType.DATE)
	private Date RequiredDate;
	
	@Temporal(TemporalType.DATE)
	private Date ShippedDate;
	
	private Float Freight;
	
	private String ShipName;
	
	private String ShipAddress;
	
	private String ShipCity;
	
	private String ShipPostalCode;
	
	private String ShipCountry;
	
	@OneToMany(mappedBy="Order")
	private Set<OrderDetails> OrderDetailss = new HashSet<OrderDetails>();

	public Order() {};
	public Order(Integer orderID,
			edu.agh.iisg.db.tuning.model.Customer customer,
			edu.agh.iisg.db.tuning.model.Employee employee, Shipper shipVia,
			Date orderDate, Date requiredDate, Date shippedDate, Float freight,
			String shipName, String shipAddress, String shipCity,
			String shipPostalCode, String shipCountry) {
		super();
		OrderID = orderID;
		Customer = customer;
		Employee = employee;
		ShipVia = shipVia;
		OrderDate = orderDate;
		RequiredDate = requiredDate;
		ShippedDate = shippedDate;
		Freight = freight;
		ShipName = shipName;
		ShipAddress = shipAddress;
		ShipCity = shipCity;
		ShipPostalCode = shipPostalCode;
		ShipCountry = shipCountry;
	}

	public Integer getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer customer) {
		Customer = customer;
	}

	public Employee getEmployee() {
		return Employee;
	}

	public void setEmployee(Employee employee) {
		Employee = employee;
	}

	public Shipper getShipVia() {
		return ShipVia;
	}

	public void setShipVia(Shipper shipVia) {
		ShipVia = shipVia;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public Date getRequiredDate() {
		return RequiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		RequiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return ShippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		ShippedDate = shippedDate;
	}

	public Float getFreight() {
		return Freight;
	}

	public void setFreight(Float freight) {
		Freight = freight;
	}

	public String getShipName() {
		return ShipName;
	}

	public void setShipName(String shipName) {
		ShipName = shipName;
	}

	public String getShipAddress() {
		return ShipAddress;
	}

	public void setShipAddress(String shipAddress) {
		ShipAddress = shipAddress;
	}

	public String getShipCity() {
		return ShipCity;
	}

	public void setShipCity(String shipCity) {
		ShipCity = shipCity;
	}

	public String getShipPostalCode() {
		return ShipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		ShipPostalCode = shipPostalCode;
	}

	public String getShipCountry() {
		return ShipCountry;
	}

	public void setShipCountry(String shipCountry) {
		ShipCountry = shipCountry;
	}

	public Set<OrderDetails> getOrderDetailss() {
		return OrderDetailss;
	}

	public void setOrderDetailss(Set<OrderDetails> orderDetailss) {
		OrderDetailss = orderDetailss;
	}
	
}
