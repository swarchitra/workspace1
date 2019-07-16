package com.visa.training.jdbc;

import java.util.List;

public class ProductDemo {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		System.out.println(dao.save(new Product(100,"oil",200,90)));
		/*Product p = dao.findById(3);
		System.out.println(p.toString());
		List<Product> list = dao.findAll();
		System.out.println(list);
		//dao.remove(2);
		list = dao.findAll();*/
		List<Product> list = dao.findAll();
		list.forEach(System.out::println);
		Product p = new Product(11, "safa", 100,100);
		dao.update(p);
		list = dao.findAll();
		list.forEach(System.out::println);
		

	}
}
