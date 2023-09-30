package com.ritesh.springboot.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.springboot.shopping.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
