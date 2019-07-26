package com.visa.training.bootproject.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.bootproject.domain.Product;
import com.visa.training.bootproject.service.ProductService;

@RestController // <-- methods of this class produce must not treated as view but JSON repsonse
public class ProductRestController {

	@Autowired
	ProductService service;

	@RequestMapping(value = "/api/products", method = RequestMethod.GET)
	public List<Product> getAll() {
	
		try {
			Thread.sleep(2000);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return service.findAll(); // Spring should transform list of products into JSON by default
	}

	// path template {id} now id is the path variable called id
	/*
	 * @RequestMapping(value = "/api/products/{id}", method = RequestMethod.GET)
	 * public Product getById(@PathVariable("id") int id) { return
	 * service.findById(id); // if product doesnt exist throw 404 code }
	 */

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getById(@PathVariable("id") int id) {

		Product p = service.findById(id); // if product doesnt exist throw 404 code
		if (p != null) {
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/api/products", method = RequestMethod.POST) // <-- request will have a body
	public ResponseEntity createProduct(@RequestBody Product toBeCreated) {
		try {
			int id = service.addNewProduct(toBeCreated);
			// Headers for giving 201 msg code
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/products/" + id));
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		
	}
	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateProduct(@PathVariable("id") int id, @RequestBody Product toBeUpdated) {
		Product p = service.findById(id);
		try {
			 p.setName(toBeUpdated.getName());
			 p.setPrice(toBeUpdated.getPrice());
			 p.setQoh(toBeUpdated.getQoh());
			 service.updateProduct(p);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteProduct(@PathVariable("id") int id) {
		Product p = service.findById(id);
		if(p==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try { 
			service.deleteProduct(id);
		} catch(IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
