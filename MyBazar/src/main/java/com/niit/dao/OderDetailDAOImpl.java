package com.niit.dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.OderDetail;

@Repository("oderDetailDAO")
@Transactional

public  class OderDetailDAOImpl implements OderDetailDAO
{  
       @Autowired
       SessionFactory sessionFactory;
	@Override
	public boolean insertOderDetail(OderDetail oderDetail) 
	{
      try 
        {
        	sessionFactory.getCurrentSession().save(oderDetail);
        	return true;
        }
                  catch(Exception e)
      {
                	  return false;
      }
      
	}
	@Override
	public boolean updateOderDetail(String username) 
	{
		 try
	        {
	        	Session session=sessionFactory.openSession();
	        	session.beginTransaction(); 
	        	Query query=session.createQuery("update CartItem set status='P' where username=:myusername and status='NA'");
	             query.setParameter("myusername", username);
	             int row_eff=query.executeUpdate();
	             if(row_eff>0){
	            	 session.getTransaction().commit();
	            session.close();}
	             
	             return true;
	        }
	                  catch(Exception e)
	      {
	                	  e.printStackTrace();
	                	  return false;
	      }
	
	}

}
