package com.slin.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.slin.app.entity.Student;
import com.slin.app.repo.StudentRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@SpringBootApplication
public class MainApp {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);
	
	public static void main (String args[]) {
		SpringApplication.run(MainApp.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(StudentRepo repository) {
		return (args) -> {
			try {
				LOGGER.info("LOGGING WORKS FINE *******************************");
				repository.save(Student.builder().name("AAA").passportNumber("123").build());
				LOGGER.info("User count in DB: {}", repository.count());
			} catch (Exception e) {
				LOGGER.error("Failed to save data---->", e);
			}
		};
	}
}