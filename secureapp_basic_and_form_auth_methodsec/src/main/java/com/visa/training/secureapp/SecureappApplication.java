package com.visa.training.secureapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) //since we are giving own security configs
public class SecureappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureappApplication.class, args);
	}

}
