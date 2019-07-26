package com.visa.training.bootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.visa.training.bootproject.dal.ProductRepository;
import com.visa.training.bootproject.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	ProductRepository dao;

	@Autowired
	public void setDao(ProductRepository dao) {
		this.dao = dao;
	}

	@Override
	public int addNewProduct(Product p) {
		// TODO Auto-generated method stub

		int id = 0;
		if (p.getPrice() * p.getQoh() >= 10000) {
			Product created = dao.save(p);
			id = created.getId();

		} else {
			throw new IllegalArgumentException("min value of stock should be atleast 10k");
		}
		return id;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub

		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		/*
		 * Product p = dao.findById(id); if(p.getPrice()*p.getQoh()>1000) { throw new
		 * IllegalArgumentException("cant remove when value>1000"); } else {
		 * dao.remove(p); }
		 */  
		 Product p = dao.findById(id);
		 if(p.getPrice() * p.getQoh() > 10000)
			 throw new IllegalArgumentException("Cannot remove stock worth more than 10K");
		 dao.deleteById(id);
	}

	@Override
	public Product updateProduct(Product p) {
		if (p == null)
			throw new NullPointerException("Product does not exist");
		dao.save(p);
		return p;
	}

}