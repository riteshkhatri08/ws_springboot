package com.ritesh.springboot.shopping;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ritesh.springboot.shopping.dao.ProductRepository;
import com.ritesh.springboot.shopping.entities.Product;

@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(ProductRepository productRepository) {
		// ! Below lambda function is not transactional
		// ! Inserts are done one after another, not in batch mode
		// ! Even if one insert statement fails, other would be successful
		return args -> {

			List<Product> products = List.of(
					new Product("Football", BigDecimal.valueOf(25.00)),
					new Product("Volleyball", BigDecimal.valueOf(500.00)),
					new Product("Basketball", BigDecimal.valueOf(1200.00)));

			productRepository.saveAll(products);

		};
	}

}
