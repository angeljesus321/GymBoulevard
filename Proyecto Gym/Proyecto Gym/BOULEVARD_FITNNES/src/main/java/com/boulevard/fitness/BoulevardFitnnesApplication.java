package com.boulevard.fitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BoulevardFitnnesApplication {

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BoulevardFitnnesApplication.class, args);
	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("PUT","POST","GET","PATCH","DELETE").allowedOrigins("http://localhost:4200");
			}
		};
	}

}
