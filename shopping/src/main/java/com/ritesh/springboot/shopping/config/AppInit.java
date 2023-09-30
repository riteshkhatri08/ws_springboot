package com.ritesh.springboot.shopping.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritesh.springboot.shopping.dao.ProductRepository;
import com.ritesh.springboot.shopping.entities.Product;

// ! method run executes once app context is initialized 
@Component
public class AppInit implements CommandLineRunner {

    ProductRepository productRepository;

    public AppInit(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Init product table with a list of productsO
        List<Product> products = List.of(

                new Product("Football", BigDecimal.valueOf(25.00)),
                new Product("Volleyball", BigDecimal.valueOf(500.00)),
                new Product("Basketball", BigDecimal.valueOf(1200.00)));

        productRepository.saveAll(products);

    }

}
