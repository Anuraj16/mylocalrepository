package com.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetails")
public class OrderDetails {
	
	@Id
	@Column(name = "order_detailId", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long order_detailId;
	private long order_id;
	private long product_id;
	private long order_number;
	private double price;
	private long quantity;
	private long discount;
	private long total_amount;
	private String size;
	private String color;
	private Date ship_date;
	
	public long getOrder_detailId() {
		return order_detailId;
	}
	public void setOrder_detailId(long order_detailId) {
		this.order_detailId = order_detailId;
	}
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public long getOrder_number() {
		return order_number;
	}
	public void setOrder_number(long order_number) {
		this.order_number = order_number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getDiscount() {
		return discount;
	}
	public void setDiscount(long discount) {
		this.discount = discount;
	}
	public long getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(long total_amount) {
		this.total_amount = total_amount;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getShip_date() {
		return ship_date;
	}
	public void setShip_date(Date ship_date) {
		this.ship_date = ship_date;
	}
}
