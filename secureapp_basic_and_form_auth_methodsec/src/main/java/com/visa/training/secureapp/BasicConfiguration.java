package com.visa.training.secureapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
	@EnableWebSecurity // used to enable web security 
	@Order(Ordered.HIGHEST_PRECEDENCE) // This is given higher precedence over other adapters
	public class BasicConfiguration extends WebSecurityConfigurerAdapter {  //Base class for customizing web security
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) 
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("user") 
	            .password("{noop}password") 
	            .roles("USER")					// In memory user detail service
	            .and()
	          .withUser("admin")
	            .password("{noop}admin") // {noop} no encoding on passwords
	            .roles("USER", "ADMIN"); // admin has both the roles user and admin
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	 http.csrf().disable(); 
	         http.antMatcher("/api/**") //should be authenticated
	             .authorizeRequests()
	             .anyRequest()
	             .authenticated() 
	             .and() 
	             .httpBasic();
	    }
	}

