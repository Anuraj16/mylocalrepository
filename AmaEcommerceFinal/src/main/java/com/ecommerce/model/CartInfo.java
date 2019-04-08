package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
 
public class CartInfo {
 
    private long orderNum;
 
    private UserInfo customerInfo;
 
    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
 
    private int subTotal;
    private int deliveryCharges;
    
    
    public CartInfo() {
 
    }
 
    public UserInfo getCustomerInfo() {
        return customerInfo;
    }
 
    public void setCustomerInfo(UserInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
 
    public List<CartLineInfo> getCartLines() {
        return this.cartLines;
    }
 
    private CartLineInfo findLineByCode(String code) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getProductInfo().getProductCodeSku().equals(code)) {
                return line;
            }
        }
        return null;
    }
 
    public void addProduct(ProductInfo productInfo, int quantity) {
        CartLineInfo line = this.findLineByCode(productInfo.getProductCodeSku());
 
        if (line == null) {
        	System.out.println("new line created");
            line = new CartLineInfo();
            line.setQuantity(0);
            line.setProductInfo(productInfo);
            this.cartLines.add(line);
        }
        System.out.println("sizde of cartlines "+cartLines.size());
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }
 
    public void validate() {
 
    }
 
    public void updateProduct(String code, int quantity) {
        CartLineInfo line = this.findLineByCode(code);
 
        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }
 
    public void removeProduct(ProductInfo productInfo) {
        CartLineInfo line = this.findLineByCode(productInfo.getProductCodeSku());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }
 
    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }
 
    public boolean isValidCustomer() {
        return this.customerInfo != null && this.customerInfo.isValid();
    }
 
    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }
 
    public double getAmountTotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getAmount();
        }
        return total;
    }
 
    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateProduct(line.getProductInfo().getProductCodeSku(), line.getQuantity());
            }
        }
 
    }

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(int deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
 
}
