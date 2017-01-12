package com.niit.testcase;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.domainobject.Supplier;

public class SupplierDaoTestCase {

	@Autowired
	static Supplier supplier;
	@Autowired
	static SupplierDao supplierDao;
	@Autowired
	static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void init()
	{
	context= new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	supplier=(Supplier) context.getBean("supplier");
	supplierDao=(SupplierDao) context.getBean("supplierDaoImpl");
	}
@Test
public void savetestcase()
{
	supplier.setId("s1");
	supplier.setName("mukesh");
	supplier.setAddress("nallakunta");
	Assert.assertEquals("savetest", true, supplierDao.save(supplier));
}
}
