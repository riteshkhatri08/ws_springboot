package com.ritesh.springboot.shopping.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.springboot.shopping.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    public List<Product> findAllByPriceLessThanEqual(BigDecimal price);
}
