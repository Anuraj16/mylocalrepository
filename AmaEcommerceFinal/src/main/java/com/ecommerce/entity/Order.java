package com.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
	
	@Id
	@Column(name = "order_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long order_id;
	private int user_id;
	private long order_number;
	private long payment_id;
	private Date order_date;
	private Date ship_date;
	private long shipper_id;
	private long freight;
	private long sales_tax;
	private long date_created;
	private int transact_status;
	private long total_amount;
	private Date payment_date;
	
	
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public long getOrder_number() {
		return order_number;
	}
	public void setOrder_number(long order_number) {
		this.order_number = order_number;
	}
	public long getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(long payment_id) {
		this.payment_id = payment_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Date getShip_date() {
		return ship_date;
	}
	public void setShip_date(Date ship_date) {
		this.ship_date = ship_date;
	}
	public long getShipper_id() {
		return shipper_id;
	}
	public void setShipper_id(long shipper_id) {
		this.shipper_id = shipper_id;
	}
	public long getFreight() {
		return freight;
	}
	public void setFreight(long freight) {
		this.freight = freight;
	}
	public long getSales_tax() {
		return sales_tax;
	}
	public void setSales_tax(long sales_tax) {
		this.sales_tax = sales_tax;
	}
	public long getDate_created() {
		return date_created;
	}
	public void setDate_created(long date_created) {
		this.date_created = date_created;
	}
	public int getTransact_status() {
		return transact_status;
	}
	public void setTransact_status(int transact_status) {
		this.transact_status = transact_status;
	}
	public long getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(long total_amount) {
		this.total_amount = total_amount;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	
	
	

}
