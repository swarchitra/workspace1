package com.visa.training.bootproject.service;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import com.visa.training.bootproject.dal.ProductRepository;
import com.visa.training.bootproject.domain.Product;

public class ProductServiceImplTest {
	// For each test case
	//1. Arrange
	//2. Act
	//3. Assert
	

	@Test
	public void add_NewProduct_Returns_ValidId_When_Value_Gt_MinValue() {
		//ARRANGE
		
		/*
		 * ProductServiceImpl impl = new ProductServiceImpl(); 
		 * // using new operator this service is not spring bean anymore
		 * hence dao.save() throws Null pointer exception
		 * So bring spring <not needed>
		 */
		
		// If u need to test service layer, mock its dependencies
		// here mock DAO to test service
		
		ProductServiceImpl impl = new ProductServiceImpl(); 
		Product toBeAdded = new Product("test", 109098, 8); //This will be inserted into DB.. avoid dummy data??
		// create a dummy DAO which contains hardcoded logic
		// That simulates DAO 
		//Called test double objects
		// READ TEST DOUBLE OBJECTS!!!
		// But for many scenarios this will be time consuming to create dummy classes for each behavior
		// Here comes Mock Objects to help! No need to create new class and hardcode logic
		// Mockito used by spring to create spring based testcases
		
		Product added = new Product("test",10000,2);
		added.setId(1);
		
		// This will give the mock obj exposing the interface
		ProductRepository mockDAO = Mockito.mock(ProductRepository.class);
		//Training mockDAO to handle save method
		Mockito.when(mockDAO.save(toBeAdded)).thenReturn(added);
		
		impl.setDao(mockDAO);
	
		//ACTION
		
		
		int id = impl.addNewProduct(toBeAdded);
		
		//ASSERT
		
		assertTrue(id > 0);
	}

}
