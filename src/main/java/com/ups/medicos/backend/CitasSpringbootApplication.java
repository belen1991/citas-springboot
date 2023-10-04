package com.ups.medicos.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan("com.ups.medicos.backend.model")
public class CitasSpringbootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CitasSpringbootApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CitasSpringbootApplication.class);
	}

}
