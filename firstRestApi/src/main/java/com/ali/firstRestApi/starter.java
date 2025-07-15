package com.ali.firstRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.ali"})
@SpringBootApplication
public class starter {

	public static void main(String[] args) {
		SpringApplication.run(starter.class, args);
	}

}
