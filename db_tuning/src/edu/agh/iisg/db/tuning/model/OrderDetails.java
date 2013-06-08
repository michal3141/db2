package edu.agh.iisg.db.tuning.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class OrderDetails {

	@Id
	private Integer odID;
	
	@ManyToOne
	@JoinColumn(name="OrderID")
	private Order Order;
	
	@ManyToOne
	@JoinColumn(name="ProductID")
	private Product Product;
	
	private Float UnitPrice;
	
	private Integer Quantity;
	
	private Float Discount;

	public OrderDetails() {};
	public OrderDetails(Integer odID, edu.agh.iisg.db.tuning.model.Order order,
			edu.agh.iisg.db.tuning.model.Product product, Float unitPrice,
			Integer quantity, Float discount) {
		super();
		this.odID = odID;
		Order = order;
		Product = product;
		UnitPrice = unitPrice;
		Quantity = quantity;
		Discount = discount;
	}

	public Integer getOdID() {
		return odID;
	}

	public void setOdID(Integer odID) {
		this.odID = odID;
	}

	public Order getOrder() {
		return Order;
	}

	public void setOrder(Order order) {
		Order = order;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public Float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		UnitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Float getDiscount() {
		return Discount;
	}

	public void setDiscount(Float discount) {
		Discount = discount;
	}
	
}
