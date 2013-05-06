package edu.agh.iisg.db.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String category;
	
	@ManyToOne()
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public Product() {};
	public Product(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------------\n");
		sb.append("Product name : " + getName() + "\n");
		sb.append("Product category : " + getCategory() + "\n"); 
		sb.append("------------------------------\n");
		return sb.toString();
	}
		
}
