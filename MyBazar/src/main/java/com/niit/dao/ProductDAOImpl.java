package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) 
	{
        try
        {
        	sessionFactory.getCurrentSession().save(product);
        	return true;
        }
		catch(Exception e)
        {
			return false;
        }
	
	}
 
	@Override 
	public boolean deleteProduct(Product product) 
	{
        try
        {
        	sessionFactory.getCurrentSession().delete(product);
        	return true;
        }
		catch(Exception e)
        {
			return false;
        }
	
	}
	@Override
	public boolean updateProduct(Product product) 
	{
        try
        {
        	sessionFactory.getCurrentSession().update(product);
        	return true;
        }
		catch(Exception e)
        {
			return false;
        }
	
	}
	@Override
	public Product getProduct(int productId) 
	{
		 try
		{
			Session session = sessionFactory.getCurrentSession();
	         Product product = (Product)session.get(Product.class,productId);
		        
		           return product;
		}
		
		catch(Exception e)
		{
			return null;
		}
		
		}
	@Override
	public List<Product> listProducts() 
	{
		 try
		 {
			 Session session = sessionFactory.openSession();
			 Query query = session.createQuery("from Product");
			 List<Product> listProducts = query.list();
			 session.close();
			 return listProducts;
		 }
		catch (Exception e) 
		 {
		return null; 
		}
	}

	@Override
	public List<Product> listProductsByCategory(int categoryId) 
	{
		 try
		 {
			 Session session = sessionFactory.openSession();
			 Query query = session.createQuery("from Product where categoryId=:catid");
			 query.setParameter("catid", categoryId);
			 List<Product> listProducts = query.list();
			 session.close();
			 return listProducts;
		 }
		catch (Exception e) 
		 {
		return null; 
		}
	}


}
