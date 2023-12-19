package com.ecommerce.www.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.www.service.IOrderService;
import com.ecommerce.www.service.IUserService;

import jakarta.servlet.http.HttpSession;

import com.ecommerce.www.model.*;

public class UserController {
	
	private final Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOrderService orderService;
	
	BCryptPasswordEncoder passEncode= new BCryptPasswordEncoder();
	
	// /usuario/registro
		@GetMapping("/register")
		public String create() {
			return "usuario/registro";
		}
		
		@PostMapping("/save")
		public String save(User user) {
			user.setRolType("USER");
			user.setPassword( passEncode.encode(user.getPassword()));
			userService.save(user);		
			return "redirect:/";
		}
		
		@GetMapping("/login")
		public String login() {
			return "usuario/login";
		}
		
		@PostMapping("/login")
		public String log(User user, HttpSession session) {		
			
			Optional<User> userl=userService.findByEmail(user.getEmail());
			//logger.info("Usuario de db: {}", user.get());
			
			if (userl.isPresent()) {
				session.setAttribute("idUser", userl.get().getId());
				
				if (userl.get().getRolType().equals("ADMIN")) {
					return "redirect:/administrador";
				}else {
					return "redirect:/";
				}
			}else {
				logger.info("Usuario no existe");
			}
			
			return "redirect:/";
		}
		
		
		@GetMapping("/shopping")
		public String selectShopping(Model model, HttpSession session) {
			model.addAttribute("sesion", session.getAttribute("idUser"));
			
			User user= userService.findById(  Integer.parseInt(session.getAttribute("idUser").toString()) ).get();
			List<Order> orders= orderService.findByUsuario(user);
			
			model.addAttribute("orders", orders);
			
			return "usuario/compras";
		}
		
		@GetMapping("/detail/{id}")
		public String shopDetail(@PathVariable Integer id, HttpSession session, Model model) {
			Optional<Order> order = orderService.findById(id);
			model.addAttribute("details", order.get().getOrderDetail());
			model.addAttribute("sesion", session.getAttribute("idusuario"));
			return "usuario/detallecompra";
		}
		
		@GetMapping("/logout")
		public String cerrarSesion( HttpSession session ) {
			session.removeAttribute("idusuario");
			return "redirect:/";
		}
		
		 
		
		

}
