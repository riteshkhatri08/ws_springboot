package com.ritesh.springaction.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// ? Above annotation is combination of below 3 annotations
// * @SpringBootCongfiguration - just a special form of @Configuration
// * @EnableAutoConfiugration - Tells spring boot to autoconfigure any
// components that it THINKS we'll need
// * @ComponentScan - Enables Component scanning- scans annotated classes
public class TacoCloudApplication {

	public static void main(String[] args) {
		// ? Configuration class and cli args are passed
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
