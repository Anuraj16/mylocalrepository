package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Products;
import com.ecommerce.model.ProductInfo;

public interface ProductDAO {

public Products findProduct(String code);
    
    public ProductInfo findProductInfo(String code) ;
  
    
    /*public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                       int maxNavigationPage, String likeName);*/
 
    public void save(ProductInfo productInfo);
    
    public List<Products> findAllProducts();
}
