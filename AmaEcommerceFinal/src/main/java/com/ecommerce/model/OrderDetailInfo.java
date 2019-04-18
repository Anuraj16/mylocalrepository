package com.ecommerce.model;

import com.ecommerce.entity.OrderDetails;

public class OrderDetailInfo {
	 
	    private String productCode;
	    private String productName;
	 
	    private long quanity;
	    private double price;
	    private double amount;
	    private String imageUrl;
	    
	    public OrderDetailInfo() {
	 
	    }
	 
	    public OrderDetailInfo(OrderDetails orderDetails) {
	        this.productCode = orderDetails.getProduct_id();
	        this.productName = orderDetails.getProduct_name();
	        this.quanity = orderDetails.getQuantity();
	        this.price = orderDetails.getPrice();
	        this.amount = orderDetails.getTotal_amount();
	    }
	 
	    public String getProductCode() {
	        return productCode;
	    }
	 
	    public void setProductCode(String productCode) {
	        this.productCode = productCode;
	    }
	 
	    public String getProductName() {
	        return productName;
	    }
	 
	    public void setProductName(String productName) {
	        this.productName = productName;
	    }
	 
	    public double getPrice() {
	        return price;
	    }
	 
	    public void setPrice(double price) {
	        this.price = price;
	    }
	 
	    public double getAmount() {
	        return amount;
	    }
	 
	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

		public long getQuanity() {
			return quanity;
		}

		public void setQuanity(long quanity) {
			this.quanity = quanity;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
}
