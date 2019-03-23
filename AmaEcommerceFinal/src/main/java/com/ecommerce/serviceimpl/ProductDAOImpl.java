package com.ecommerce.serviceimpl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.entity.Products;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.service.ProductDAO;

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Products findProduct(String code) {
		 Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Products.class);
	        crit.add(Restrictions.eq("productCodeSku", code));
	        return (Products) crit.uniqueResult();
	}

	public ProductInfo findProductInfo(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(ProductInfo productInfo) {
		  String code = productInfo.getProductCodeSku();
		  
	        Products product = null;
	 
	        boolean isNew = false;
	        if (code != null) {
	            product = this.findProduct(code);
	        }
	        if (product == null) {
	            isNew = true;
	            product = new Products();
	            product.setDateCreated(new Date());
	        }
	        product.setProductCodeSku(code);
	        product.setProductName(productInfo.getProductName());
	        product.setUnitPrice(productInfo.getUnitPrice());
	 
	        if (productInfo.getFileData() != null) {
	            /*byte[] image = productInfo.getFileData().getBytes();
	            if (image != null && image.length > 0) {
	                product.setImage(image);
	            }*/
	        }
	        if (isNew) {
	            this.sessionFactory.getCurrentSession().persist(product);
	        }
	        this.sessionFactory.getCurrentSession().flush();

	}

}
