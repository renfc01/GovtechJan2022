package com.example.govtech;

import java.util.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GovtechApplication {
	public static DB = new HashMap();
	public static void main(String[] args) {
		SpringApplication.run(GovtechApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Hello World!");
			System.out.println("Init \"DB\"");
			GovtechApplication.DB.put("John", 2500.05)
			GovtechApplication.DB.put("Mary Posa", 4000.00)


//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}

		};
	}
}
