package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.Product;

@Controller
public class CartController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;

	@RequestMapping(value = "/AddToCart/{productId}")
	public String addCartItem(@RequestParam("quantity") int quantity, @PathVariable("productId") int productId,
			HttpSession session, Model m) 
	{
		Product product = productDAO.getProduct(productId);
		
		String username=(String)session.getAttribute("username");
		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getPrice());
		cartItem.setUsername(username);
		cartItem.setStatus("NA");
		
		cartDAO.addCartItem(cartItem);
		List<CartItem> cartItems =cartDAO.showCartItems(username);
		m.addAttribute("cartItems",cartItems); 
		m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmmount(cartItems));

		return "Cart";

	}
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@RequestParam("quantity") int quantity,@PathVariable("cartItemId")int cartItemId,HttpSession session, Model m)
	{
		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		String username=(String)session.getAttribute("username");
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		List<CartItem> cartItems=cartDAO.showCartItems(username);
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmmount(cartItems));
		
		return "Cart";
		
	}
	
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId,HttpSession session,Model m)
	{
		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		String username=(String)session.getAttribute("username");
		cartDAO.deleteCartItem(cartItem);
		
		
		
		List<CartItem> cartItems=cartDAO.showCartItems(username);
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmmount(cartItems));
		
		
		return "Cart";
		
	}

    @RequestMapping(value="/continueShopping")
    public String continueShopping(Model m)
    {
    	m.addAttribute("productList", productDAO.listProducts());
		return "ProductDisplay";
    	
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
