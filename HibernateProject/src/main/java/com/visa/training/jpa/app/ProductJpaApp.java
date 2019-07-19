package com.visa.training.jpa.app;

import java.util.List;

import com.visa.training.jpa.dal.JpaProductDAO;
import com.visa.training.jpa.domain.Product;

public class ProductJpaApp {
	public static void main(String[] args) {
		JpaProductDAO dao = new JpaProductDAO();
		Product test = new Product("hibernate",10,100);
		Product saved = dao.save(test);
		System.out.println(saved);
		/*Product update_obj = new Product("new_product",123,10);
		update_obj.setId(14);
		dao.update(update_obj);
		//dao.delete(update_obj);
		 * 
		 */
		List<Product> all = dao.findAll();
		all.forEach(System.out :: println);
		
		//test findbyprice
		System.out.println("Products having price greater than 200");
		all = dao.findByPriceGreaterThan(100);
		all.forEach(System.out :: println);
		
		System.exit(0);
	}

}
