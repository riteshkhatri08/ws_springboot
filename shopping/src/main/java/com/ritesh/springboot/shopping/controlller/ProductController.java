package com.ritesh.springboot.shopping.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.springboot.shopping.entities.Product;
import com.ritesh.springboot.shopping.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value="/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

}
