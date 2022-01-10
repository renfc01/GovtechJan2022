package com.example.govtech;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;

@SpringBootApplication
public class GovtechApplication {
	public static LinkedHashMap<String, User> DB = new LinkedHashMap<>();
	public static void main(String[] args) {
		SpringApplication.run(GovtechApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Hello World!");
			System.out.println("Init \"DB\"");
			GovtechApplication.DB.put("John Doe", new User("John Doe", 2500));
			GovtechApplication.DB.put("Jane Boe", new User("Jane Boe", 3500));
			GovtechApplication.DB.put("Mary Posa", new User("Mary Posa", 4000));
			GovtechApplication.DB.put("Poor Posa", new User("Poor Posa", 1000));
		};
	}
}
