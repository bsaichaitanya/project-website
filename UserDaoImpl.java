package com.niit.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDao;
import com.niit.domainobject.User;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public boolean save(User user) {
	
	 try {
		sessionFactory.getCurrentSession().save(user);
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		// TODO Auto-generated method stub
		return true;
	}
@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
@Transactional
	public List<User> list() {
		String hql="from User"; 
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		// TODO Auto-generated method stub
		return query.list();
	}
@Transactional
	public User get(String id) {
		// TODO Auto-generated method stub
	
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
@Transactional
	public User validate(String id, String password) {
		// TODO Auto-generated method stub
		String hql= "from User where id='"+id+"' and password='"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User) query.uniqueResult();
	}

}