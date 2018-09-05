package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.OderDetailDAO;
import com.niit.model.CartItem;
import com.niit.model.OderDetail;

@Controller
public class OrderController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OderDetailDAO oderDetailDAO;
	
	
@RequestMapping("/checkout")
public String checkOutProcess(Model m,HttpSession session)
{
	String username=(String)session.getAttribute("username");
	List<CartItem> cartItems=cartDAO.showCartItems(username);
	
	PdfGenrator.createPdf(cartItems,username,this.calcTotalPurchaseAmmount(cartItems));
	m.addAttribute("cartItems",cartItems); 
	m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmmount(cartItems));
	
	return "MyOrder";
	
}
@RequestMapping("/payment")
public String paymentProcess(Model m,HttpSession session)
{

	String username=(String)session.getAttribute("username");
	List<CartItem> cartItems=cartDAO.showCartItems(username);
	m.addAttribute("cartItems",cartItems);  
	m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmmount(cartItems));


	return "Payment";
}
@RequestMapping(value="/paymentProcess" ,method=RequestMethod.POST)
public String paymentProcessing(@RequestParam("paymenttype") String paymentMode,Model m,HttpSession session)
{
	
	String username=(String)session.getAttribute("username");
	List<CartItem> cartItems=cartDAO.showCartItems(username);
	m.addAttribute("cartItems",cartItems);  

	int totalPurchaseAmount=this.calcTotalPurchaseAmmount(cartItems);
	m.addAttribute("totalPurchaseAmount",totalPurchaseAmount);

	OderDetail oderDetail=new OderDetail();
	oderDetail.setPaymentMode(paymentMode);
	oderDetail.setUsername(username);
	oderDetail.setTotalPurchaseAmount(totalPurchaseAmount);
	oderDetail.setOderDate(new java.util.Date());
	
	
	oderDetailDAO.insertOderDetail(oderDetail);
	oderDetailDAO.updateOderDetail(username);
	
	m.addAttribute("oderID",oderDetail.getOderId());
	m.addAttribute("oderDATE",oderDetail.getOderDate());
	return "Reciept";
	
}



public int calcTotalPurchaseAmmount(List<CartItem> cartItems)
{
	int totalPurchaseAmount=0;
	int count=0;
	while(count<cartItems.size())
	{
		CartItem cartItem= cartItems.get(count);
		totalPurchaseAmount=totalPurchaseAmount+cartItem.getQuantity()*cartItem.getPrice();
 		count++;
	}
	return totalPurchaseAmount;
	
}


}
