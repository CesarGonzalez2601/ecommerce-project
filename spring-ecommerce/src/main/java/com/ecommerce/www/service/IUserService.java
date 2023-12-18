package com.ecommerce.www.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.www.model.*;

public interface IUserService {
	
	List<User> findAll();
	Optional<User> findById(Integer id);
	User save (User user);
	Optional<User> findByEmail(String email);

}
