package com.visa.training.jpa.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SA")
public class SavingsAccount extends Account{

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(float balance) {
		super(balance);
	}

	@Override
	public String toString() {
		return "SavingsAccount [id=" + id + ", balance=" + balance + "]";
	}
	
	

}
