package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;

public class DBConfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
		context.refresh();

	//	CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	//	Category category = new Category();
	//	category.setCategoryDesc("Samsumg Mobile");

	//	category.setCategoryName("Mobile");

	//	categoryDAO.addCategory(category);
	//	System.out.println("Category Object Saved ");

		//SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

	//	Supplier supplier = new Supplier();
	//	supplier.setSupplierName("Abhishek");
	//	supplier.setSupplierAddr("Preet Vihar");
	//	supplier.setSupplierDesc("On Time Delivery");
		
	//	supplierDAO.addSupplier(supplier);
	//	System.out.println("Object created nice wow wow");
		
		
		
		/*UserDAO userDAO =(UserDAO) context.getBean("userDAO");
		UserDetail userDetail = new UserDetail();
	
		userDetail.setPassword("123456");
		userDetail.setAddress("63, Nehru Nagar Lucknow");
		userDetail.setMobile("7839129293");
		userDetail.setEnabled("True");
		userDetail.setRole("ROLE_ADMIN");
		userDetail.setEmail("abhi96255@gmail.com");
		userDetail.setCoustomername("Suresh Kumar");
		userDAO.registerUser(userDetail);
		System.out.println("Object created nice wow");
	*/
		
	/*	
		CartDAO cartDAO =(CartDAO) context.getBean("cartDAO");
		CartItem cartItem = new CartItem();
	    cartItem.setProductId(137);
		cartItem.setPrice(38000);
		cartItem.setProductName("lenovo k8 note");
		cartItem.setQuantity(20);
		cartItem.setUsername("Abhishek001");
		cartItem.setStatus("NA");
		cartDAO.addCartItem(cartItem);
		System.out.println("Object created nice wowwww");
*/
	}
}
   
