package com.ecommerce.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ProductInfo {

	private String productCodeSku;
    private String productName;
    private double unitPrice;
    
    private boolean newProduct=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;

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
