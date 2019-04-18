package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.OrderDetails;
import com.ecommerce.model.CartInfo;
import com.ecommerce.model.OrderDetailInfo;
import com.ecommerce.model.OrderInfo;

public interface OrderDAO {

	public void saveOrder(CartInfo cartInfo);
	 
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderInfo> getAllOrders(String userName);
    
    public List<OrderDetailInfo> listOrderDetailInfos(long orderNumber);
}
