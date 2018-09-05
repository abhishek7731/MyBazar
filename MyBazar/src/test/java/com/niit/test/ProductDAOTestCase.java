package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class ProductDAOTestCase {
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	 @Test
     public void addCategoryTest()
     {
		

		 Product product = new Product();
   	     product.setProductName("Samsumg S7");
   	     product.setProductDesc("Samsumg Mobile With 4g Features");
   	     product.setPrice(12000);
   	     product.setStock(20);
   	     product.setCategoryId(1);
   	     product.setSupplierId(1);
   	     
   		assertTrue("problem in adding category", productDAO.addProduct(product)); //assert true issliya use kar raha coz we are using boolean
    	
    	 
     }
	



}
