package com.visa.training.jpa.app;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.text.DefaultEditorKit.CutAction;

import com.visa.training.jpa.dal.JpaUtil;
import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.Address;
import com.visa.training.jpa.domain.Customer;
import com.visa.training.jpa.domain.SavingsAccount;

public class AssociationTestApp {

	public static void createAccountAndCustomerSeperately() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer c = new Customer("fn","mn","ln",new Date(System.currentTimeMillis()));
		SavingsAccount sa = new SavingsAccount(1234);
		em.persist(c);
		sa.setCustomer(c); // This line tells that this account belongs to c customer Foreign key association
		em.persist(sa);
		
		
		
		
		tx.commit();
		em.close();
	}
	
	public static void createAccountAndCustomerTogether() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer c = new Customer("fn","mn","ln",new Date(System.currentTimeMillis()));
		SavingsAccount sa = new SavingsAccount(1000);
		
		
		sa.setCustomer(c); // This line tells that this account belongs to c customer Foreign key association
		//em.persist(c);
		// without persist(c) c becomes transient hence while saving it throws exception
		// we can cascade persist to another object
		
		
		em.persist(sa);
		
		
		
		
		tx.commit();
		em.close();
	}
	public static void main(String[] args) {
		//createAccountAndCustomerSeperately();
		//readAccountAlongWithCustomer();
		//createAccountAndCustomerTogether();
		testLazy();
		testManyToMany();
		System.exit(0);
	}

	private static void testManyToMany() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer c = new Customer("fname","mname","lastname", new Date(System.currentTimeMillis()));
		Address a  = new Address("s11", "s12", "c11", "S11", "626627", "C11");
		System.out.println(c.getAddresses().add(a));
		em.persist(c);
		
		c.getAddresses().remove(0);
		System.out.println(c.getAddresses());
		
		
		em.close();
		
		
		
		
		tx.commit();
		
	}

	private static void testLazy() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Customer c1 = em.find(Customer.class, 40);
		//em.close();if uncommented LazyInitialization exception is thrown
		// Cascading is not in putting objects in memory
		// to avoid this exception we can fetch() set EAGER by default it is LAZY
		// when it is changed to EAGER, it loads accounts when account is loaded. no exception arises
		System.out.println(c1);
		Account a = c1.getAccounts().get(0);
		System.out.println(a.getBalance());
		System.out.println(a);
		
		//em.close();
	}

	private static void readAccountAlongWithCustomer() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		SavingsAccount sa = em.find(SavingsAccount.class,41);
		System.out.println(sa.getCustomer());
		
	}

}
