package com.visa.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.training.ui.ProductConsoleUI;

public class ProductApp {
	
	public static void main(String[] args) {
		//ProductConsoleUI ui = new ProductConsoleUI(); no new on spring bean
		
		Class[] configs = {ProductAppConfiguration.class, PersistenceJPAConfiguration.class};
		ApplicationContext springContainer = new AnnotationConfigApplicationContext(configs);
		// This line brings up the spring container and instantiates the bean
		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		ui.createProductWithUI();
		// Exception arises since object's dependencies are not considered
		// This problem is solved by Spring
	}
	

}
