package com.visa.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

@Component
public class ProductConsoleUI {

	ProductService service;
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}

	public void createProductWithUI() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a name :");
		String name = kb.nextLine();
		System.out.println("Enter a price :");
		float price = Float.parseFloat(kb.nextLine());
		System.out.println("Enter a qoh :");
		int qoh = Integer.parseInt(kb.nextLine());
		kb.close();
		
		Product p = new Product(name, price, qoh);
		
		
		try {
			int id = service.addNewProduct(p);
			System.out.println("Product created with :"+id);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	
}
