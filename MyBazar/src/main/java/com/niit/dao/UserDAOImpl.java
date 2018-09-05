package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;

@Repository("userDAO")
@Transactional

public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserDetail userDetail) 
	{
	try 
	{
		sessionFactory.getCurrentSession().save(userDetail);
		return true;
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		return false;
	}

}
	@Override
	public boolean updateUserDetail(UserDetail userDetail) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}

	}
	@Override
	public UserDetail getUserDetail(String username) 
	{
		try {
			Session session = sessionFactory.getCurrentSession();
			UserDetail userDetail = (UserDetail) session.get(UserDetail.class, username);

			return userDetail; 
		} 
		catch (Exception e) 
		{
			return null;
		}

	}
	@Override
	public List<UserDetail> listUser() 
	{
	Session session=sessionFactory.getCurrentSession();
	 Query query = session.createQuery("from UserDetail");
	 List<UserDetail> listUser = query.list();
	 
	 return listUser;
	
	
	}

}
