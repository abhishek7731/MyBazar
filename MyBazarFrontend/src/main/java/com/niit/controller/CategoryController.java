package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	boolean flag=false;
@RequestMapping(value = "/category")
public String showCategoryPage(Model m) // whatsoever data we want to send to model page it can be sent to model page
{
	flag= false;
	List<Category> listCategories = categoryDAO.listCategory();
	m.addAttribute("categoryList",listCategories); // whenever we need to add object in jsp page we use addAttribute funtion
	m.addAttribute("flag",flag);
	return "Category";  //category.jsp
	
}
  // now we need to insert the data
@RequestMapping(value = "/InsertCategory",method=RequestMethod.POST)
public String insertCategory(@RequestParam("catname")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
{
	flag=false;
	Category category = new Category();
	category.setCategoryName(categoryName);
	category.setCategoryDesc(categoryDesc);
	
	categoryDAO.addCategory(category);
	
	// for retriving the data or the data saved in data base we need to see it jo abi abi add kiya hai usko retrive bhi karna hai
	
	List<Category> listCategories = categoryDAO.listCategory();
    m.addAttribute("categoryList",listCategories);
    m.addAttribute("flag",flag);
    return "Category";
 	
}

 @RequestMapping(value="/deleteCategory/{categoryID}")
 public String deleteCategory(@PathVariable("categoryID") int categoryId, Model m)
 {
	 flag=false;
	Category category = categoryDAO.getCategory(categoryId);
	categoryDAO.deleteCategory(category);
	
	

	List<Category> listCategories = categoryDAO.listCategory();
    m.addAttribute("categoryList",listCategories); 
    m.addAttribute("flag",flag);
	 return "Category";
 }

 @RequestMapping(value ="/editCategory/{categoryID}")
 public String editCategory(@PathVariable("categoryID") int categoryId, Model m)
 {
	 flag=true;
	 Category category= categoryDAO.getCategory(categoryId);
	 m.addAttribute("CategoryData", category);
	
	 
	 m.addAttribute("flag",flag);   
	 return "Category";
	 
 }
 


 @RequestMapping(value = "/UpdateCategory",method=RequestMethod.POST)
 public String updateCategory(@RequestParam("catid")int categoryId,@RequestParam("catname")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
 {
 	flag=false;
 	Category category = categoryDAO.getCategory(categoryId);
 	category.setCategoryName(categoryName);
 	category.setCategoryDesc(categoryDesc);
 	
 	categoryDAO.updateCategory(category);
 	
 	// for retriving the data or the data saved in data base we need to see it
 	
 	List<Category> listCategories = categoryDAO.listCategory();
     m.addAttribute("categoryList",listCategories);
     m.addAttribute("flag",flag);
     return "Category";
  	
 }


}
 