package com.ecommerce.www.controller;

import java.util.List;
import com.ecommerce.www.model.*;
import com.ecommerce.www.service.ProductService;
import com.ecommerce.www.service.IOrderService;
import com.ecommerce.www.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private IOrderService orderService;
	
	@GetMapping("")
	public String home(Model model) {

		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "administrador/home";
	}
	
	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "administrador/usuarios";
	}
	
	@GetMapping("/orders")
	public String ordenes(Model model) {
		model.addAttribute("orders", orderService.findAll());
		return "administrador/ordenes";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable Integer id) {
		Order orden= orderService.findById(id).get();
		
		model.addAttribute("details", orden.getOrderDetail());
		
		return "administrador/detalleorden";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable Integer id) {
		Order order= orderService.findById(id).get();
		
		model.addAttribute("details", order.getOrderDetail());
		
		return "administrador/detalleorden";
	}

}
