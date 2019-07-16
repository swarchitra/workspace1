package com.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testcase {

	
	// Arrange - Act - Assert
	@Test
	public void createAccount_returns_validId_when_balance_gt_minBalance() {
		
		AccountService ac = new AccountService();
		int id = ac.createNewAccount("SA", 100000);
		assertTrue(id > 0);
	}

}
