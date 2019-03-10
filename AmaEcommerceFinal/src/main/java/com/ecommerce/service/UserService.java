package com.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.Users;

@Service
public interface UserService {

	void save (Users user);
}
