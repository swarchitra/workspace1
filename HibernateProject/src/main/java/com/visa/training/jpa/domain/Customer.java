package com.visa.training.jpa.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="customer")
//One customer has 1 / many account
// 1 - N relationship


public class Customer {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	String firstname;
	String middlename;
	String lastname;
	Date dateofjoin;
	
	
	//for customer to account
	@OneToMany (mappedBy = "customer", fetch = FetchType.EAGER) // EAGER to avoid lazy initialization 
	
	// coz account is the owning side
	// join Column should be only in the owning side
	List<Account> accounts = new ArrayList<>();
	
	
	//for customer to address
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	
	@JoinTable (name = "customer_address", //@Jointable for  mapping association table 
	joinColumns = @JoinColumn (name="cust_id"), // Tells FK that maps from customer to address and viceversa
	inverseJoinColumns = @JoinColumn (name="address_id"))
	
	
	
	
	List<Address> addresses= new ArrayList<>();
	
	
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Customer() {
	
	}

	public Customer(String firstname, String middlename, String lastname, Date dateofjoin) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofjoin = dateofjoin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + ", dateofjoin=" + dateofjoin + "]";
	}
	
	
	
	

}
