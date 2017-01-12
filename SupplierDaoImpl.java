package com.niit.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.SupplierDao;
import com.niit.domainobject.Supplier;
@Repository
public class SupplierDaoImpl implements SupplierDao {
@Autowired
private SessionFactory sessionFactory;
public SupplierDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
@Transactional
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
	}
@Transactional
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
	}
@Transactional
	public Supplier getbyid(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id) ;
	}
@Transactional
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		String hql="from Supplier";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
	
	

}
