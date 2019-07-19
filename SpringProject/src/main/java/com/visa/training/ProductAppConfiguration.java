package com.visa.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.visa.training.dal.ProductDAO;
import com.visa.training.dal.ProductDAOInMemoryImpl;
import com.visa.training.service.ProductService;
import com.visa.training.service.ProductServiceImpl;
import com.visa.training.ui.ProductConsoleUI;

// This class gives the configuration meta data

@Configuration
@ComponentScan(basePackages = "com.visa.training")
public class ProductAppConfiguration {
	
	// to do wiring of objects use @Bean
	
	/*
	 * @Bean public ProductDAO dao() { return new ProductDAOInMemoryImpl(); // The
	 * application code does not have concrete class name }
	 * 
	 * @Bean public ProductService service() { ProductServiceImpl service = new
	 * ProductServiceImpl(); service.setDao(dao()); return service; }
	 * 
	 * @Bean public ProductConsoleUI ui() { ProductConsoleUI ui = new
	 * ProductConsoleUI(); ui.setService(service()); return ui; }
	 * 
	 */
	
}
