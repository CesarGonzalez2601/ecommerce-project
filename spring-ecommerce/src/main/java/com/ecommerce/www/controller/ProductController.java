package com.ecommerce.www.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.www.model.Product;
import com.ecommerce.www.model.User;
import com.ecommerce.www.service.ProductService;
import com.ecommerce.www.service.UploadFileService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productoService;
	
	@Autowired
	private UploadFileService upload;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productService.findAll());
		return "productos/show";
	}

	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	
	@PostMapping("/save")
	public String save(Product product, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
		//imagen
		if (product.getProductId()==null) { // cuando se crea un producto
			String nombreImagen= upload.saveImage(file);
			product.setProductImage(nombreImagen);
		}else {
		}
		productService.save(product);
		return "redirect:/productos";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Product product= new Product();
		Optional<Product> optionalProducto=productoService.get(id);
		product= optionalProducto.get();
		model.addAttribute("product", product);
		
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Product product, @RequestParam("img") MultipartFile file ) throws IOException {
		Product p= new Product();
		p=productoService.get(product.getProductId()).get();
		
		if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem
			
			product.setProductImage(p.getProductImage());
		}else {// cuando se edita tbn la imagen			
			//eliminar cuando no sea la imagen por defecto
			if (!p.getProductImage().equals("default.jpg")) {
				upload.deleteImage(p.getProductImage());
			}
			String nameImage= upload.saveImage(file);
			product.setProductImage(nameImage);
		}
		product.setUser(p.getUser());
		productService.update(product);		
		return "redirect:/productos";
	}
	
	@GetMapping("/delete/{prodductId}")
	public String delete(@PathVariable Integer productId) {
		
		Product p = new Product();
		p=productoService.get(productId).get();
		
		//eliminar cuando no sea la imagen por defecto
		if (!p.getProductImage().equals("default.jpg")) {
			upload.deleteImage(p.getProductImage());
		}
		
		productoService.delete(productId);
		return "redirect:/productos";
	}
	
}
