package com.visa.training.jpa.domain;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="account")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name="acct_type", discriminatorType = DiscriminatorType.STRING)

public abstract class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	float balance;
	
	// specify nature of association and foreign key
	//@ManyToOne  --> This will not cascade the persistence
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn (name = "cust_id") // <-- is the foreign key
	Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Account() {
	
	}


	public Account(float balance) {
		this.balance = balance;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	
}
