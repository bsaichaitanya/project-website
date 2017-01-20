package com.niit.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.domainobject.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	public ProductDaoImpl(){
		
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Product> list() {
		log.debug("Starting of the method calliing list");
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method calling list");
		return query.list();
		
	}
	
	
	@Transactional
	public Product get(String productID) {
		log.debug("Starting of the method : get");
		String hql = "from Product where productID='"+productID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) query.list();
		
		if(list != null && !list.isEmpty()){
			return list.get(0);	
		}
		log.debug("Ending of the method : get");
		return null;
	}
	
	@Transactional
	public Product getByName(String name){
		log.debug("Starting of the method: getByName");
		String hql = "from Product where name='"+name+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method : getByName");
		return (Product)query.uniqueResult();
		
	}
	
	@Transactional
	public boolean saveOrUpdate(Product product) {
		log.debug("Starting of the method: saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("Not able to save or update record"+e.getMessage());
			e.printStackTrace();
		}
		log.debug("Starting of the method: saveOrUpdate");
		return true;
	}
	
	
		
	
	@Transactional
	public boolean delete(String productID){
		log.debug("Starting of the method: delete");
		try {
			Product product = new Product();
			product.setProductID(productID);
			sessionFactory.getCurrentSession().delete(product);
			log.debug("Ending of the method: delete");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Not able to delete the record"+e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	
	
}
