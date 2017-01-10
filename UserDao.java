package com.niit.dao;

import java.util.List;

import com.niit.domainobject.User;

public interface UserDao {
	
	
	public boolean save(User user);
	public boolean update(User user);
	public List<User> list();
	public  User get(String id);
	public User validate(String id ,String password);

}
