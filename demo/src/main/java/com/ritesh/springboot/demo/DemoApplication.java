package com.ritesh.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ritesh.springboot.demo.json.Greeting;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Greeting englishGreeting() {

		return new Greeting("Hello!");
	}

	@Bean
	public Greeting frenchGreeting() {

		return new Greeting("Salut!");
	}

}
