package com.thomasgodoi.pillsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("application.properties")
public class PillsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PillsBackendApplication.class, args);
	}

}
