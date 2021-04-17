package com.management.CardManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.management")
public class CardManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardManagementSystemApplication.class, args);
	}

}
