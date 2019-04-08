package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Orders" ,uniqueConstraints= { 
		@UniqueConstraint(columnNames = { "order_number" })})
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1342342444L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long order_id;
	//private int user_id;
	private String user_name;
	private long order_number;
	private long payment_id;
	private Date order_date;
	private Date ship_date;
	private long shipper_id;
	private long freight;
	private long sales_tax;
	private Date date_created;
	private int transact_status;
	private double total_amount;
	private Date payment_date;
	private String customer_name;
	private String customer_email;
	private String customer_phone;
	private String customer_address;
	private int rowstate;

	
	@OneToMany(cascade=CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "order",
			orphanRemoval=true)
	private Set<OrderDetails> orderDetailsSet ;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(Order order) {
		this.user_name=order.getUser_name();
		this.order_number=order.getOrder_number();
		this.payment_id=order.getPayment_id();
		this.order_date=order.getOrder_date();
		this.ship_date=order.getShip_date();
		this.shipper_id=order.getShipper_id();
		this.freight=order.getFreight();
		this.sales_tax=order.getSales_tax();
		this.date_created=order.getDate_created();
		this.transact_status=order.getTransact_status();
		this.total_amount=order.getTotal_amount();
		this.payment_date=order.getPayment_date();
	}
	
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
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
	public int getTransact_status() {
		return transact_status;
	}
	public void setTransact_status(int transact_status) {
		this.transact_status = transact_status;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public int getRowstate() {
		return rowstate;
	}

	public void setRowstate(int rowstate) {
		this.rowstate = rowstate;
	}

	public Set<OrderDetails> getOrderDetailsSet() {
		return orderDetailsSet;
	}

	public void setOrderDetailsSet(Set<OrderDetails> orderDetailsSet) {
		this.orderDetailsSet = orderDetailsSet;
	}
	
	
	

}
