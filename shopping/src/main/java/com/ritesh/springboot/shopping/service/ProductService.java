package com.ritesh.springboot.shopping.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ritesh.springboot.shopping.dao.ProductRepository;
import com.ritesh.springboot.shopping.entities.Product;

@Service
@Transactional // ! use transactional makes sure if one insert statement fails , others are
               // ! rolledback
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public void initializeDatabse() {

        List<Product> products = List.of(
                new Product("Football", BigDecimal.valueOf(25.00)),
                new Product("Volleyball", BigDecimal.valueOf(500.00)),
                new Product("Basketball", BigDecimal.valueOf(1200.00)));

        productRepository.saveAll(products);

    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {

        return productRepository.findById(id);

    }

    public Optional<Product> addProduct(Product product) {
        try {
            return Optional.of(productRepository.save(product));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

}
