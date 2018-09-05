package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;

@Repository("supplierDAO")
@Transactional

public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Supplier getSupplier(int SupplierId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Supplier supplier = (Supplier) session.get(Supplier.class, SupplierId);

			return supplier;
		} 
		catch (Exception e) 
		{
			return null;
		}

	}

	@Override
	public List<Supplier> listSupplier() {

		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Supplier");
			List<Supplier> listSupplier = query.list();
			return listSupplier;
		} catch (Exception e) {
			return null;
		}

	}
}
