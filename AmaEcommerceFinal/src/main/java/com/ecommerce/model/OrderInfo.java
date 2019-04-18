package com.ecommerce.model;

import java.util.Date;
import java.util.List;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderDetails;

public class OrderInfo {
    private Date orderDate;
    private long orderNum;
    private double amount;
 
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;
 
    private List<OrderDetailInfo> details;
 
    public OrderInfo() {
 
    }
 
    public OrderInfo(Order order) {
        this.orderDate = order.getOrder_date();
        this.orderNum = order.getOrder_number();
        this.amount = order.getTotal_amount();
 
        this.customerName = order.getCustomer_name();
        this.customerAddress = order.getCustomer_address();
        this.customerEmail = order.getCustomer_email();
        this.customerPhone = order.getCustomer_phone();
    }

    public Date getOrderDate() {
        return orderDate;
    }
 
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
 
    public double getAmount() {
        return amount;
    }
 
    public void setAmount(double amount) {
        this.amount = amount;
    }
 
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    public String getCustomerAddress() {
        return customerAddress;
    }
 
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
 
    public String getCustomerEmail() {
        return customerEmail;
    }
 
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
 
    public String getCustomerPhone() {
        return customerPhone;
    }
 
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public List<OrderDetailInfo> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetailInfo> details) {
		this.details = details;
	}
}
