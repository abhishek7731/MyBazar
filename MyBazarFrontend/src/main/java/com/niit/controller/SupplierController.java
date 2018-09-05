package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDAO supplierDAO;
	boolean flag=false;
	@RequestMapping(value = "/supplier")
	public String showSupplierPage(Model m) // whatsoever data we want to send
											// to model page it can be sent to
											// model page
	{
         flag=false;
		List<Supplier> listSupplier = supplierDAO.listSupplier();
		m.addAttribute("supplierList", listSupplier); // whenever we need to add
														// object in jsp page we
														// use addAttribute
														// funtion
		m.addAttribute("flag",flag);
		return "Supplier"; // category.jsp

	}

	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplier(@RequestParam("supname") String supplierName,
			@RequestParam("supDesc") String supplierDesc, @RequestParam("supAddr") String supplierAddr, Model m) {
		flag=false;
		Supplier supplier = new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		supplier.setSupplierAddr(supplierAddr);

		supplierDAO.addSupplier(supplier);

		// for retriving the data or the data saved in data base we need to see
		// it jo abi abi add kiya hai usko retrive bhi karna hai

		List<Supplier> listSupplier = supplierDAO.listSupplier();
		m.addAttribute("supplierList", listSupplier);
		m.addAttribute("flag",flag);
		return "Supplier";

	}

	@RequestMapping(value = "/deleteSupplier/{supplierID}")
	public String deleteSupplier(@PathVariable("supplierID") int supplierId, Model m) {
		flag=false;
		Supplier supplier = supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);

		List<Supplier> listSupplier = supplierDAO.listSupplier();
		m.addAttribute("supplierList", listSupplier);
		m.addAttribute("flag",flag);
		return "Supplier";
	}

	@RequestMapping(value = "/editSupplier/{supplierID}")
	public String editCategory(@PathVariable("supplierID") int supplierId, Model m) {
		flag=true;
		Supplier supplier = supplierDAO.getSupplier(supplierId);
		m.addAttribute("SupplierData", supplier);
		m.addAttribute("flag",flag);
		return "Supplier";

	}
	@RequestMapping(value = "/UpdateSupplier",method=RequestMethod.POST)
	 public String updateSupplier(@RequestParam("supid")int supplierId,@RequestParam("supname")String supplierName,@RequestParam("supDesc")String supplierDesc,@RequestParam("supAddr")String supplierAddr,Model m)
	 {
		flag=false;
	 	Supplier supplier = supplierDAO.getSupplier(supplierId);
	supplier.setSupplierName(supplierName);
	supplier.setSupplierAddr(supplierAddr);
	supplier.setSupplierDesc(supplierDesc);
	 	supplierDAO.updateSupplier(supplier);
	 	// for retriving the data or the data saved in data base we need to see it
	 	
	 	List<Supplier> listSupplier = supplierDAO.listSupplier();
	     m.addAttribute("supplierList",listSupplier);
	     m.addAttribute("flag",flag);
	     return "Supplier";
	  	
	 }
}
