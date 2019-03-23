package com.ecommerce.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="Products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	private String productCodeSku;
	private String vendorProductId;
	private String productName;
	@Lob
	private String productDescription;
	private long supplierId;
	private long categoryId;
	private int qtyPerUnit;
	private double unitPrice;
	private String availableSizes;
	private String availableColors;
	private int sizeId;
	private int colorId;
	private double discount;
	private int unitsInStock;
	@Lob
	private String destFilePath;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	private int rowstate;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getVendorProductId() {
		return vendorProductId;
	}
	public void setVendorProductId(String vendorProductId) {
		this.vendorProductId = vendorProductId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public int getQtyPerUnit() {
		return qtyPerUnit;
	}
	public void setQtyPerUnit(int qtyPerUnit) {
		this.qtyPerUnit = qtyPerUnit;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getAvailableSizes() {
		return availableSizes;
	}
	public void setAvailableSizes(String availableSizes) {
		this.availableSizes = availableSizes;
	}
	public String getAvailableColors() {
		return availableColors;
	}
	public void setAvailableColors(String availableColors) {
		this.availableColors = availableColors;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getProductCodeSku() {
		return productCodeSku;
	}
	public void setProductCodeSku(String productCodeSku) {
		this.productCodeSku = productCodeSku;
	}
	public String getDestFilePath() {
		return destFilePath;
	}
	public void setDestFilePath(String destFilePath) {
		this.destFilePath = destFilePath;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getRowstate() {
		return rowstate;
	}
	public void setRowstate(int rowstate) {
		this.rowstate = rowstate;
	}
	

}
