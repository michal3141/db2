package edu.agh.iisg.db.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@ElementCollection
	@OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
	private Collection<Product> products = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	
	public void populateWithSomeProducts() {
		Product p1 = new Product("Apple", "Fruit");
		Product p2 = new Product("Pear", "Fruit");
		Product p3 = new Product("Beef", "Meat");
		p1.setCustomer(this);
		p2.setCustomer(this);
		p3.setCustomer(this);
		products.add(p1);
		products.add(p2);
		products.add(p3);
	}
	
	
}
