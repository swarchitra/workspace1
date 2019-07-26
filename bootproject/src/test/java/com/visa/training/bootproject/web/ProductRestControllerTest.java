package com.visa.training.bootproject.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.visa.training.bootproject.domain.Product;
import com.visa.training.bootproject.service.ProductService;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductRestController.class)
// test with spring container

public class ProductRestControllerTest {

	// utility object
	@Autowired
	MockMvc mvc;
	
	@MockBean
	ProductService service; // similar to mockito.mock() spring takes care of it automatically
	
	@Test
	public void testGetByID() throws Exception {
		
		//send http req and verify json with that id
		
	       //Arrange
        Product data = new Product("test", 1999, 1000);
        data.setId(1);
        Mockito.when(service.findById(1)).thenReturn(data);
        //Act and Assert
        mvc.perform(get("api/products/{id}", 1).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)));

		
		
		
	}
	
}
