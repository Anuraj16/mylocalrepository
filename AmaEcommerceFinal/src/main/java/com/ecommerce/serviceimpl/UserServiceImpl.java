package com.ecommerce.serviceimpl;

import com.ecommerce.entity.Users;
import com.ecommerce.service.UserService;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Users user) {
		System.out.println("in userservice impl");
		try {
			Session session = sessionFactory.getCurrentSession();
			System.out.println(user.getUsername()+" #### "+user.getRoles());
			session.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	
	public Users validateUser(Users user){
		try {
			Session session = sessionFactory.getCurrentSession();
			//users=(Users) session.get(Users.class, userName.trim());
	        Criteria crit = session.createCriteria(Users.class)
	        		.add(Restrictions.eq("username", user.getUsername()))
	        		.add(Restrictions.eq("password", user.getPassword()));
	        user=(Users) crit.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}	
		
}
