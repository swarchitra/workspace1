package com.visa.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

@Controller

public class ProductController {
	
	//@Autowired <-- this can be used and no need of setter method
	ProductService service;
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	@Autowired
    ProductValidator validator;
    
/*	@RequestMapping("/display")
	public String Product( ) {
		return "product";
	}*/
	
	@RequestMapping(value="/display",method=RequestMethod.GET)
	public ModelAndView displayProduct() {
		Product product = new Product();
		List<Product> list = service.findAll();
		Map<String, Object> map = new HashMap<>();
		map.put("products",list);
		map.put("product",product);
		return new ModelAndView("product",map );
	}
	
	@RequestMapping(value="/display",method=RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("product")Product p) {
		
		int id = service.addNewProduct(p);
		Product product = new Product();
		List<Product> list = service.findAll();
		Map<String, Object> map = new HashMap<>();
		map.put("products",list);
		map.put("product",product);
		return new ModelAndView("product",map );
	}
	
	@RequestMapping("/delete")
	public ModelAndView removeProduct(@RequestParam("id")int id){
		service.deleteProduct(id);
		Product product = new Product();
		List<Product> list = service.findAll();
		Map<String, Object> map = new HashMap<>();
		map.put("products",list);
		map.put("product",product);
		return new ModelAndView("product",map );	}
	
	/*
	 * @ModelAttribute("products") public List<Product> getAllProducts() { return
	 * service.findAll(); }
	 */
	
}
