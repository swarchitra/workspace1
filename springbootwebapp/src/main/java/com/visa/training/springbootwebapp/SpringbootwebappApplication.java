package com.visa.training.springbootwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.visa.training.springbootwebapp.ui.BookConsoleUI;
import com.visa.training.springbootwebapp.ui.ChapterConsoleUI;

@SpringBootApplication
public class SpringbootwebappApplication {

	public static void main(String[] args) {
		
		ApplicationContext springContainer=
		  SpringApplication.run(SpringbootwebappApplication.class, args);
		  
		BookConsoleUI ui = springContainer.getBean(BookConsoleUI.class);
		  ui.findAll();
		  
		/*
		 * ChapterConsoleUI ui = springContainer.getBean(ChapterConsoleUI.class);
		 * ui.createChapter();
		 */
	}
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new 
        InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


}
