package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO  
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) 
	{
	try
	{
		sessionFactory.getCurrentSession().save(category); // save funtion saves the object in database
		
		
		return true; //will go to junit test case in assert true
	}
	catch(Exception e)
	{
		return false;
	}
	
	}
	
	
	
	

	@Override
	public boolean updateCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		}
	@Override
	public boolean deleteCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		}

	@Override
	public Category getCategory(int categoryId) 
	{
	 try
	{
		Session session = sessionFactory.getCurrentSession();
           Category category = (Category)session.get(Category.class,categoryId);
	        
	           return category;
	}
	
	catch(Exception e)
	{
		return null;
	}
	
	}
	@Override
	public List<Category>  listCategory() 
	{
		 try
			{
				Session session = sessionFactory.openSession();
				Query query = session.createQuery("from Category"); //it means in h2 database where there is category table fetch all the category data
				List<Category> listCategories =query.list(); // now put all the data in list categories
				session.close();
		         
			        
			           return listCategories ; // returned to junit test case
			}
			
			catch(Exception e)
			{
				return null;
			}
			
			}
}
