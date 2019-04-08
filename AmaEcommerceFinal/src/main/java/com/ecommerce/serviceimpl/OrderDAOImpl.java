package com.ecommerce.serviceimpl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderDetails;
import com.ecommerce.entity.Users;
import com.ecommerce.model.CartInfo;
import com.ecommerce.model.CartLineInfo;
import com.ecommerce.model.OrderDetailInfo;
import com.ecommerce.model.OrderInfo;
import com.ecommerce.service.OrderDAO;


public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveOrder(CartInfo cartInfo) {
		System.out.println("in OrderDAOImpl impl");
		try {
			Session session = sessionFactory.getCurrentSession();
			long orderNum = this.getMaxOrderNum() + 1;
			System.out.println("order number "+orderNum);
			Order order = new Order();
	        //order.setId(UUID.randomUUID().toString());
	        order.setOrder_number(orderNum);
	        order.setOrder_date(new Date());
	        order.setTotal_amount(cartInfo.getAmountTotal());
	        order.setUser_name(cartInfo.getCustomerInfo().getUsername());
	        order.setDate_created(new Date());
	        order.setCustomer_name(cartInfo.getCustomerInfo().getFirstName());
	        order.setCustomer_email(cartInfo.getCustomerInfo().getEmailId());
	        order.setCustomer_address(cartInfo.getCustomerInfo().getAddress());
	        order.setCustomer_phone(cartInfo.getCustomerInfo().getPhone());
	        order.setRowstate(1);
	        
	    	Set<OrderDetails> orderDetailsSet = new HashSet<OrderDetails>() ;
	        
	        List<CartLineInfo> lines = cartInfo.getCartLines();
	        
	        for (CartLineInfo line : lines) {
	            OrderDetails detail = new OrderDetails();
	           // detail.setId(UUID.randomUUID().toString());
	          //  detail.setOrder(order);
	            detail.setTotal_amount(line.getAmount());
	            detail.setPrice(line.getProductInfo().getUnitPrice());
	            detail.setOrder_number(orderNum);
	            detail.setQuantity(line.getQuantity());
	            detail.setProduct_id(line.getProductInfo().getProductCodeSku());
	            detail.setDate_created(new Date());
	            detail.setRowstate(1);
	            //String code = line.getProductInfo().getCode();
	           // Product product = this.productDAO.findProduct(code);
	           // detail.setProduct(product);
	            orderDetailsSet.add(detail);
	           // session.persist(detail);
	        }
	        System.out.println("size of orderdetails set before save "+orderDetailsSet.size());
	        order.setOrderDetailsSet(orderDetailsSet);
			
			session.persist(order);
			cartInfo.setOrderNum(orderNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	 private long getMaxOrderNum() {
	       // String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
	        long value =0;
	        System.out.println("in get max order number");
	        try {
	        	 Session session = sessionFactory.getCurrentSession();
	 	        Criteria crit = session.createCriteria(Order.class)
	 	        		.add(Restrictions.ne("rowstate", -1));
	 	       Projection projection = Projections.max("order_number");
	 	       crit.setProjection(projection);
	 	       value=(Long) crit.uniqueResult();
	 	       System.out.println("value obtained for get max num "+value);
			} catch (Exception e) {
				e.printStackTrace();
			}
	       
	        /*if (value == null) {
	            return 0;
	        }*/
	        return value;
	    }
	 
	public OrderInfo getOrderInfo(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
