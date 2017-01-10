package com.niit.testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.domainobject.User;

import junit.framework.Assert;





public class UserDaoTestCase {
	@Autowired
	static  User user;
	@Autowired
	static UserDao userDao;
	@Autowired
	static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user = (User) context.getBean("user");
		userDao = (UserDao) context.getBean("userDaoImpl");
	}
	
	@Test
	public void getUserTestCase()
	
	{
	user = userDao.get("m1");
	Assert.assertNotNull("getusertestcase", user);
	}
	@Test
	public void getalluserstestcase()
	{
		int size= userDao.list().size();
		Assert.assertEquals("lenghtcheck",3,size);
		
	}
@Test
	public void validatetestcase()
	{
		user=userDao.validate("m1", "password");
		Assert.assertNotNull("valid testcase", user);
	}
@Test
public void savtestcase()
{
	user.setId("m4");
	user.setName("Rakesh Yadav");
	user.setEmail("Rakesh00@yahoo.com");
	user.setPassword("Rakhi24");
	user.setPhone("9960284648");
	user.setRole("Customer");
	Assert.assertEquals("savetestcase", true, userDao.save(user));
}
@Test
public void update()
{
	user.setId("m4");
	user.setName("sai chaitanya goud");
}
	
}
