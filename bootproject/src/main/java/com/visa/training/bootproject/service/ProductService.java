package com.visa.training.bootproject.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.training.bootproject.domain.Product;

public interface ProductService {

	public int addNewProduct(Product p);
	public Product findById(int id);
	public List<Product> findAll();
	public void deleteProduct(int id);
	public Product updateProduct(Product product);
	
}
