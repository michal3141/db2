package edu.agh.iisg.db.tuning.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shippers")
public class Shipper {
	
	@Id
	private Integer ShipperID;
	
	private String CompanyName;
	
	private String Phone;
	
	@OneToMany(mappedBy="ShipVia")
	private Set<Order> Orders = new HashSet<Order>();

	public Shipper() {}
	public Shipper(Integer shipperID, String companyName, String phone) {
		super();
		ShipperID = shipperID;
		CompanyName = companyName;
		Phone = phone;
	}

	public Integer getShipperID() {
		return ShipperID;
	}

	public void setShipperID(Integer shipperID) {
		ShipperID = shipperID;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Set<Order> getOrders() {
		return Orders;
	}

	public void setOrders(Set<Order> orders) {
		Orders = orders;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-------Shipper------\n");
		sb.append(getShipperID() + "\n");
		sb.append(getCompanyName() + "\n");
		sb.append(getPhone() + "\n");
		return sb.toString();
	}
	
}
