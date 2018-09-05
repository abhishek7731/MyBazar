package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OderDetailDAO;
import com.niit.model.OderDetail;

public class OderDetailDAOTestCase {
	static OderDetailDAO oderDetailDAO;

	@BeforeClass
	public static void configure() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		oderDetailDAO = (OderDetailDAO) context.getBean("oderDetailDAO");
	}

	@Test
	public void insertOderDetailTest() {
		OderDetail oderDetail = new OderDetail();
		oderDetail.setUsername("suresh");
		oderDetail.setTotalPurchaseAmount(45000);
		oderDetail.setOderDate(new java.util.Date());
		oderDetail.setPaymentMode("CC");
		assertTrue("Problem in inserting OderDetail", oderDetailDAO.insertOderDetail(oderDetail));
	}
@Test
public void updateCartItemsStatus()
{
	assertTrue("Problem in updating CartItem:", oderDetailDAO.updateOderDetail("Abhishek001"));
}

}
