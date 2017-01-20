package com.niit.dao;

import java.util.List;

import com.niit.domainobject.Product;

public interface ProductDao {

	public List<Product> list();
	
	public Product get(String id);
	
	public Product getByName(String name);
	
	public boolean saveOrUpdate(Product product);
	
	public boolean delete(String productID);


}