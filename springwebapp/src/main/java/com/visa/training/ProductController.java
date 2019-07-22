package com.visa.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

@Controller

public class ProductController {
	
	ProductService service;
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	
	@RequestMapping("/displayproduct")
	public ModelAndView showProduct() {
		List<Product> list = service.findAll();
		Map<String, Object> model = new HashMap<>();
		model.put("products",list);
		return new ModelAndView("product", model);
	}
	@RequestMapping("/createproduct")
	public String addProduct(@RequestParam("pname")String pname,@RequestParam("pprice")float pprice, @RequestParam("pqoh")int pqoh ) {
		Product p = new Product(pname,pprice,pqoh);
		int id = service.addNewProduct(p);
		return "product";
	}
	
	@RequestMapping("/delete")
	public String removeProduct(@RequestParam("id")int id){
		service.deleteProduct(id);
		return "product";
	}
	
	
	
}
