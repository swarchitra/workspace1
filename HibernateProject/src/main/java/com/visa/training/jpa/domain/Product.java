package com.visa.training.jpa.domain;

import javax.persistence.*;

@Entity
@Table (name="product")
public class Product {
	
	@Id
	@Column (name = "product_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY) //unique and auto incremented
	int id;
	
	@Column (name = "product_name")
	String name;
	
	@Column (name = "product_price")
	float price;
	
	@Column (name = "product_qoh")
	int qoh;
	
	//JPA requires a no argument constructor
	public Product() {
	
	}

	public Product(String name, float price, int qoh) {
		this.name = name;
		this.price = price;
		this.qoh = qoh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQoh() {
		return qoh;
	}

	public void setQoh(int qoh) {
		this.qoh = qoh;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", qoh=" + qoh + "]";
	}
	
	
	
	
}
