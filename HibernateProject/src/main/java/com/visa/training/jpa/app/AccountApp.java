package com.visa.training.jpa.app;
import com.visa.training.jpa.dal.AccountDAO;
import com.visa.training.jpa.domain.*;

public class AccountApp {
	
	
	
	
	public static void main(String[] args) {
		AccountDAO ad = new AccountDAO();
		//test save for both accounts
		SavingsAccount sa = new SavingsAccount(1000);
		CurrentAccount ca = new CurrentAccount(2200, 199);
		ad.save(sa);
		ad.save(ca);
		//test find by ID
		Account a = ad.findById(sa.getId());
		System.out.println(a);
		//System.out.println(a.getClass().getName());
		a = ad.findById(ca.getId());
		System.out.println(a);
		
		//test update
		sa.setBalance(20000);
		ad.update(sa);
		// test delete 
		ad.delete(sa);
		System.exit(0);
	}

	
	
}
