package com.ecommerce.www.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.www.model.Order;
import com.ecommerce.www.model.User;

public interface IOrderService {
	
	List<Order> findAll();
	Optional<Order> findById(Integer id);
	Order save (Order order);
	String generateOrderNumber();
	List<Order> findByUsuario (User user);

}

