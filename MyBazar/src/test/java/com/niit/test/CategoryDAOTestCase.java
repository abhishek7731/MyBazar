 package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTestCase 
{  

	static CategoryDAO categoryDAO; 
	
	@BeforeClass
	public static  void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh(); 
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
    	
	
	}
	@Ignore
     @Test
     public void addCategoryTest()
     {
		

		 Category category = new Category();
   	 category.setCategoryName("Lenovo");
   	 category.setCategoryDesc("Lenovo Mobiles");
   	 

    	 
    	assertTrue("problem in adding category", categoryDAO.addCategory(category)); //assert true issliya use kar raha coz we are using boolean
    	
    	 
     }
	
@Ignore	
@Test
public void updateCategoryTest()
{
	 Category category = categoryDAO.getCategory(1);
	 
	 category.setCategoryName("Samsumg");
	 category.setCategoryDesc("Samsumg Mobile with 4g feature");

  assertTrue("Problem in updating the category ",categoryDAO.updateCategory(category));
}
     @Test
     public void deleteCategoryTest()
     {
    	 Category category = categoryDAO.getCategory(4);
    	 assertTrue("Problem in deleting the Category", categoryDAO.deleteCategory(category));

    }
        @Test
        public void listCategoriesTest()
        {
        	List<Category> listCategories = categoryDAO.listCategory();
        	assertTrue("problem in listing categories", listCategories.size()>0);
        	for(Category category:listCategories)
        	{
        		System.out.print(category.getCategoryId()+":::");
        		System.out.print(category.getCategoryName()+":::");
        		System.out.println(category.getCategoryDesc()+":::");


        		
        	}
        }



}  