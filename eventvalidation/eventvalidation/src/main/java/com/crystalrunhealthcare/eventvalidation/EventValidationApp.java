package com.crystalrunhealthcare.eventvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EventValidationApp extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EventValidationApp.class);
	
}
	/**
	 * main class of program
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EventValidationApp.class, args);
	}

}
