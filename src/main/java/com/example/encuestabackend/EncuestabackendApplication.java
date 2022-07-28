package com.example.encuestabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.encuestabackend.security.AppProperties;

@SpringBootApplication
public class EncuestabackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncuestabackendApplication.class, args);
		System.out.println("FUNCIONANDO");
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContext(){
		return new SpringApplicationContext();
	}
	
	@Bean(name = "AppProperties")
	public AppProperties getaProperties(){
		return new AppProperties();
	}
}
