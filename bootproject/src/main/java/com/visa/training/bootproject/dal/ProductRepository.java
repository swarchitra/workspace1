package com.visa.training.bootproject.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.bootproject.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	public Product findById(int id);
	
	public List<Product> findAll();
	
	/*
	 * public List<Product> findByPrice(int price);
	 * 
	 * public List<Product> findByPriceLessThan(int price);
	 * 
	 * public List<Product> findByNameLike(String name);
	 * 
	 * @Query("select p from Product as p where p.price * p.qoh < 100000") public
	 * List<Product> myComplexQuery();
	 */
}
