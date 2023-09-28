package com.ornek.ndmkcn;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ndmkcn Blog Site", version = "1.0.0.0", description = "This is a ndmkcn blog site swagger documentation."))
public class NdmkcnApplication {

	public static void main(String[] args) {
		SpringApplication.run(NdmkcnApplication.class, args);
	}

}
