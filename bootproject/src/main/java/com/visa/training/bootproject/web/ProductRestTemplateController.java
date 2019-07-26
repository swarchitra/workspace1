package com.visa.training.bootproject.web;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.visa.training.bootproject.domain.Product;


public class ProductRestTemplateController {

	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:8080/api/products/",
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<List<Product>>(){});
	static String REST_SERVICE_URI = "http://localhost:8080/api"; 
	List<Product> employees = response.getBody();
	static Scanner scan = new Scanner(System.in);

	public static void getProduct() {
		System.out.println("GET API REQUEST");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Enter ID of product to be displayed..");
	//	scan = new Scanner(System.in);
		int id = scan.nextInt();
		Product p = restTemplate.getForObject(REST_SERVICE_URI+"/products/"+id, Product.class);
		System.out.println(p);
	}
	private static void createProduct() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Enter name");
		String name = scan.next();
		System.out.println("Enter Price");
		float price  = scan.nextFloat();
		System.out.println("Enter qoh");
		int qoh = scan.nextInt();
		Product p = new Product(name, price, qoh);
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/products/", p, Product.class);
		String location = uri.toASCIIString();;
		System.out.println("Location: "+location);;
		String some = uri.getPath();
		String[] url = some.split("/");
		//System.out.println(url);
		System.out.println("Created product of ID: "+ url[3]);
				
	}
	
	
	private static void getAllProducts() {
		RestTemplate restTemplate = new RestTemplate();
		//List<Product> list = restTemplate.getForObject(REST_SERVICE_URI+"/products/", List.class);
		List<Product> list;
		ResponseEntity<List<Product>> response = restTemplate.exchange(REST_SERVICE_URI+"/products", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
  		System.out.println("The list of products are -------");
		list = response.getBody();
  		list.forEach(System.out:: println);
	}
	private static void updateProduct() {
		System.out.println("Testing update product API----------");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Enter id of product to be updated");
		int id = scan.nextInt();
		Product p = new Product("oil",10051,134);
		p.setId(id);
		restTemplate.put(REST_SERVICE_URI+"/products/"+id, p, Product.class);
	    System.out.println(p);
	}
	
	private static void deleteProduct() {
		System.out.println("Testing delete product API --------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI+"/products/64", Product.class);
		
	}

	public static void main(String[] args) {
		//getProduct();
		//createProduct();
		long start = System.currentTimeMillis();
		getAllProducts();	
		long stop = System.currentTimeMillis();
		System.out.println("Listing took "+(stop-start)+" ms");
		doSomeOtherWork();
	}
	private static void doSomeOtherWork() {
		System.out.println("Doing some other work");
		
	}
	
}
