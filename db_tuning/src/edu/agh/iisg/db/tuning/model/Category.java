package edu.agh.iisg.db.tuning.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	private Integer CategoryID;
	
	private String CategoryName;
	
	@Column(length=255)
	private String Description;
	
	@OneToMany(mappedBy="Category")
	private Set<Product> Products = new HashSet<Product>();

	public Category() {};
	public Category(Integer categoryID, String categoryName, String description) {
		super();
		CategoryID = categoryID;
		CategoryName = categoryName;
		Description = description;
	}

	public Integer getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(Integer categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Set<Product> getProducts() {
		return Products;
	}

	public void setProducts(Set<Product> products) {
		Products = products;
	}
	
	
}
