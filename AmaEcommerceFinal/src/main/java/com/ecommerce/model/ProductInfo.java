package com.ecommerce.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ecommerce.entity.Products;

public class ProductInfo {

	private String productCodeSku;
    private String productName;
    private double unitPrice;
    
    private boolean newProduct=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;
    
    public ProductInfo() {

    }
    
    public ProductInfo(Products products) {
    	this.productCodeSku = products.getProductCodeSku();
    	this.productName = products.getProductName();
    	this.unitPrice = products.getUnitPrice();
    	this.newProduct = products.isNewProduct();
    	this.fileData = products.getFileData();
    	
    }
    
    public ProductInfo(String productCodeSku,String productName,double unitPrice,boolean newProduct,CommonsMultipartFile fileData) {
    	this.productCodeSku = productCodeSku;
    	this.productName = productName;
    	this.unitPrice = unitPrice;
    	this.newProduct = newProduct;
    	this.fileData = fileData;
    }

	public String getProductCodeSku() {
		return productCodeSku;
	}

	public void setProductCodeSku(String productCodeSku) {
		this.productCodeSku = productCodeSku;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isNewProduct() {
		return newProduct;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
}
