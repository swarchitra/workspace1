package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	// Never do new on spring bean
	
	ProductDAO dao;
	
	@Autowired
	// spring searches for a class implementing interface
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public int addNewProduct(Product p) {
		if(p.getPrice() * p.getQoh() >= 10000) {
			// only save
			int id = 0;
			Product created = dao.save(p); // loose coupling imple details not given explicit
			id =  created.getId();
			
			return id;
		}
		throw new IllegalArgumentException("min value of stock should be 10K");
		
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}
	
	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		Product p = dao.findById(id);
		if(p.getPrice() * p.getQoh() < 1000) {
			throw new IllegalArgumentException("can't remove when value > 1000");
		}
		
		dao.remove(id);
	}
}
