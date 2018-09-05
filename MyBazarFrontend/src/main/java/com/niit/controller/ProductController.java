package com.niit.controller;

import java.awt.image.ImageFilter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	boolean flag = false;
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value = "/product")
	public String showProductPage(Model m) // whatsoever data we want to send to
											// model page it can be sent to
											// model page
	{
		flag = false;
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts); // whenever we need to add

		// object in jsp page // use addAttribute
		m.addAttribute("categoryList", categoryDAO.listCategory());

		m.addAttribute("flag", flag); // funtion

		return "ManageProduct"; // category.jsp

	}
          @RequestMapping("/totalProductInfo/{productId}")
          public String showTotalProductDisplay(@PathVariable("productId")int productId,Model m)
          {
        	  
        	  Product product = productDAO.getProduct(productId);
        	  m.addAttribute("product", product);
        	  m.addAttribute("categoryName", categoryDAO.getCategory(product.getCategoryId()).getCategoryName());
        	  return "TotalProductDisplay";
          }
          
	@RequestMapping("/productDisplay")
	public String displayAllProducts(Model m) {
		m.addAttribute("productList", productDAO.listProducts());
		return "ProductDisplay";
	}

	@RequestMapping(value = "/InsertProduct", method = RequestMethod.POST)
	public String insertProduct(@RequestParam("productname") String productName,
			@RequestParam("productDesc") String productDesc, @RequestParam("productprice") int price,
			@RequestParam("productstock") int stock, @RequestParam("productsupplier") int supplierId,
			@RequestParam("categoryId") int categoryId, @RequestParam("file") MultipartFile imageFile, Model m) {
		flag = false;
		Product product = new Product();

		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setPrice(price);
		product.setStock(stock);
		product.setCategoryId(categoryId);
		product.setSupplierId(supplierId);
		productDAO.addProduct(product);
		String path = "C:\\Users\\ASUS\\workspace\\MyBazarFrontend\\src\\main\\webapp\\resources\\images\\";
		System.out.println(product.getProductId());
		path = path + String.valueOf(product.getProductId()) + ".jpg";
		File file = new File(path);
		if (!imageFile.isEmpty()) {
			try {
				byte[] buffer = imageFile.getBytes();
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();

			}

			catch (Exception e) {
				System.out.println("Exception Arised:" + e);
			}
		}

		else {
			m.addAttribute("Error Info", "There is system problem no image insertion");
		}

		

		// for retriving the data or the data saved in data base we need to see
		// it jo abi abi add kiya hai usko retrive bhi karna hai

		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		m.addAttribute("categoryList", categoryDAO.listCategory());
		m.addAttribute("flag", flag);
		return "ManageProduct";

	}

	@RequestMapping(value = "/deleteProduct/{productID}")
	public String deleteCategory(@PathVariable("productID") int productId, Model m) {
		flag = false;
		Product product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);

		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		m.addAttribute("flag", flag);
		return "ManageProduct";
	}

	@RequestMapping(value = "/editProduct/{productID}")
	public String editProduct(@PathVariable("productID") int productId, Model m) {
		flag = true;
		Product product = productDAO.getProduct(productId);
		m.addAttribute("ProductData", product);
		m.addAttribute("categoryList", categoryDAO.listCategory());
		m.addAttribute("flag", flag);
		return "ManageProduct";

	}

	@RequestMapping(value = "/UpdateProduct", method = RequestMethod.POST)
	public String updateProduct(@RequestParam("productid") int productId,
			@RequestParam("productname") String productName, @RequestParam("productDesc") String productDesc,
			@RequestParam("productprice") int price, @RequestParam("productstock") int stock,
			@RequestParam("productsupplier") int supplierId, @RequestParam("categoryId") int categoryId, Model m) {
		flag = false;
		Product product = productDAO.getProduct(productId);

		product.setProductName(productName);
		product.setProductDesc(productDesc);

		product.setPrice(price);
		product.setStock(stock);
		product.setCategoryId(categoryId);
		product.setSupplierId(supplierId);
		productDAO.addProduct(product);
		List<Product> listproducts = productDAO.listProducts();
		m.addAttribute("ProductData", listproducts);
		m.addAttribute("flag", flag);
		return "ManageProduct";
	}

}