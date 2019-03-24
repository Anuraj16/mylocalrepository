package com.ecommerce.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ecommerce.entity.Products;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.service.ProductDAO;

@Component
public class ProductInfoValidator implements Validator{

	@Autowired
    private ProductDAO productDAO;

	public boolean supports(Class<?> clazz) {
		  return clazz == ProductInfo.class;
	}

	public void validate(Object target, Errors errors) {
		ProductInfo productInfo = (ProductInfo) target;
		 System.out.println("Inside product validation");
        // Check the fields of ProductInfo class.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productCodeSku", "NotEmpty.productForm.productCodeSku");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "NotEmpty.productForm.productName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice", "NotEmpty.productForm.unitPrice");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productDescription", "NotEmpty.productForm.productDescription");
 
        if(productInfo.getUnitPrice()<=0.0) {
        	errors.rejectValue("unitPrice", "NotEmpty.productForm.unitPrice");
        }
        String code = productInfo.getProductCodeSku();
        if (code != null && code.length() > 0) {
            if (code.matches("\\s+")) {
                errors.rejectValue("productCodeSku", "Pattern.productForm.productCodeSku");
            } else if(productInfo.isNewProduct()) {
                Products product = productDAO.findProduct(code);
                if (product != null) {
                    errors.rejectValue("productCodeSku", "Duplicate.productForm.productCodeSku");
                }
            }
        }
	}
 
    
    
}
