package com.ecommerce.www.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.www.model.Product;
import com.ecommerce.www.service.IUserService;
import com.ecommerce.www.service.ProductService;

import jakarta.servlet.http.HttpSession;

public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private IUserService userService;
	
	
	@GetMapping("")
	public String home(Model model, HttpSession session) {
		
		model.addAttribute("products", productService.findAll());
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "usuario/home";
	}
	
	@GetMapping("producthome/{id}")
	public String productHome(@PathVariable Integer id, Model model) {
		Product product = new Product();
		Optional<Product> productoOptional = productService.get(id);
		product = productoOptional.get();

		model.addAttribute("product", product);

		return "usuario/productohome";
	}

}
