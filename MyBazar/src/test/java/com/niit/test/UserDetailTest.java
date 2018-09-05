package com.niit.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

public class UserDetailTest {

	private static AnnotationConfigApplicationContext context=null;
	private static UserDAO userDAO=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO =(UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testRegisterUser() {
		UserDetail userDetail = new UserDetail();
		userDetail.setUsername("Suresh007");
		userDetail.setPassword("pass123");
		userDetail.setAddress("63, Nehru Nagar Lucknow");
		userDetail.setMobile("7839129293");
		userDetail.setEnabled("true");
		userDetail.setRole("ROLE_ADMIN");
		userDetail.setEmail("abhi96255@gmail.com");
		userDetail.setCoustomername("Suresh Kumar");
		
		assertTrue("Fail to register",userDAO.registerUser(userDetail));
	}

	@Ignore
	@Test
	public void testUpdateUserDetail() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetUserDetail() {
		fail("Not yet implemented");
	}

}
