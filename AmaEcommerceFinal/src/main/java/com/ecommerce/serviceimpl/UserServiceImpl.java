package com.ecommerce.serviceimpl;

import com.ecommerce.entity.Users;
import com.ecommerce.service.UserService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Users user) {
		System.out.println("in userservice impl");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
