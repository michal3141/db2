package edu.agh.iisg.db.tuning.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	private Integer ProductID;
	
	private String ProductName;
	
	@ManyToOne
	@JoinColumn(name="SupplierID")
	private Supplier Supplier;
	
	@ManyToOne
	@JoinColumn(name="CategoryID")
	private Category Category;
	
	private String QuantityPerUnit;
	
	private Float UnitPrice;
	
	private Integer UnitsInStock;
	
	private Integer UnitsOnOrder;
	
	private Integer ReorderLevel;
	
	private Integer Discontinued;
	
	@OneToMany(mappedBy="Product")
	private Set<OrderDetails> OrderDetailss = new HashSet<OrderDetails>();

	public Product() {};
	public Product(Integer productID, String productName,
			edu.agh.iisg.db.tuning.model.Supplier supplier,
			edu.agh.iisg.db.tuning.model.Category category,
			String quantityPerUnit, Float unitPrice, Integer unitsOnStock,
			Integer unitsOnReorder, Integer reorderLevel, Integer discontinued) {
		super();
		ProductID = productID;
		ProductName = productName;
		Supplier = supplier;
		Category = category;
		QuantityPerUnit = quantityPerUnit;
		UnitPrice = unitPrice;
		UnitsInStock = unitsOnStock;
		UnitsOnOrder = unitsOnReorder;
		ReorderLevel = reorderLevel;
		Discontinued = discontinued;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Supplier getSupplier() {
		return Supplier;
	}

	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public String getQuantityPerUnit() {
		return QuantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		QuantityPerUnit = quantityPerUnit;
	}

	public Float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		UnitPrice = unitPrice;
	}

	public Integer getUnitsInStock() {
		return UnitsInStock;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		UnitsInStock = unitsInStock;
	}

	public Integer getUnitsOnOrder() {
		return UnitsOnOrder;
	}

	public void setUnitsOnOrder(Integer unitsOnOrder) {
		UnitsOnOrder = unitsOnOrder;
	}

	public Integer getReorderLevel() {
		return ReorderLevel;
	}
	
	public void setReorderLevel(Integer reorderLevel) {
		ReorderLevel = reorderLevel;
	}
	
	public Integer getDiscontinued() {
		return Discontinued;
	}

	public void setDiscontinued(Integer discontinued) {
		Discontinued = discontinued;
	}

	public Set<OrderDetails> getOrderDetailss() {
		return OrderDetailss;
	}

	public void setOrderDetailss(Set<OrderDetails> orderDetailss) {
		OrderDetailss = orderDetailss;
	}
	
}
