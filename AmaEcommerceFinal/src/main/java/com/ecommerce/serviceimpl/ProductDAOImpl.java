package com.ecommerce.serviceimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
		 Session session;
		 try {
			    session = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
			    session = sessionFactory.openSession();
			}
	        Criteria crit = session.createCriteria(Products.class);
	        crit.add(Restrictions.eq("productCodeSku", code));
	        return (Products) crit.uniqueResult();
	}

	public ProductInfo findProductInfo(String code) {
		Session session;
		Products products =null;
		ProductInfo productInfo=null;
		
		 try {
			    session = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
			    session = sessionFactory.openSession();
			}
		 try {
			 Criteria crit = session.createCriteria(Products.class);
		        crit.add(Restrictions.eq("productCodeSku", code));
		        products=(Products) crit.uniqueResult();
		        productInfo = new ProductInfo(products);
		} catch (Exception e) {
			System.out.println("Some exception occurred "+e);
		}
	        return productInfo ;
	}

	public void save(ProductInfo productInfo) {
		try {
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
		            product.setRowstate(1);
		        }
		        product.setProductCodeSku(code);
		        product.setProductName(productInfo.getProductName());
		        product.setUnitPrice(productInfo.getUnitPrice());
		        product.setProductDescription(productInfo.getProductDescription());
		      //  product.setDestFilePath("E:/Product Images/"+productInfo.getProductCodeSku());
		        product.setDestFilePath(productInfo.getDestFilePath());
		        product.setFileNames(productInfo.getFileNames());
		        product.setVendorUsername(productInfo.getVendorUserName());
		        if (isNew) {
		            this.sessionFactory.getCurrentSession().persist(product);
		        }
		} catch (Exception e) {
			System.out.println("Some exception occurred "+e);
		}
		 

	}

	public List<Products> findAllProducts() {
		 Session session;
		 try {
			    session = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
			    session = sessionFactory.openSession();
			}
	        Criteria crit = session.createCriteria(Products.class);
	        crit.add(Restrictions.ne("rowstate", -1));
	        return ( List<Products>) crit.list();
	}

	public List<Products> findAllProductsForVendor(String username) {
		 Session session;
		 try {
			    session = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
			    session = sessionFactory.openSession();
			}
	        Criteria crit = session.createCriteria(Products.class);
	        crit.add(Restrictions.eq("vendorUsername", username));
	        crit.add(Restrictions.ne("rowstate", -1));
	        return ( List<Products>) crit.list();
	}
}
