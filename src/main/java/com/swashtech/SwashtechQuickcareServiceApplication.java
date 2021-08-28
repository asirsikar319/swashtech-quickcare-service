package com.swashtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SwashtechQuickcareServiceApplication {

	public static void main(String[] args) {
		System.err.print("Starting SpringBoot");
		ConfigurableApplicationContext context = SpringApplication.run(SwashtechQuickcareServiceApplication.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		System.err.println("MongoDB URL -------> : "+env.getProperty("spring.data.mongodb.uri"));
	}

}
