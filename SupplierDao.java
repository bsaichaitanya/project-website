package com.niit.dao;

import java.util.List;

import com.niit.domainobject.Supplier;

public interface SupplierDao {
	
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public Supplier getbyid(String id);
	public List<Supplier> list();
	

}
