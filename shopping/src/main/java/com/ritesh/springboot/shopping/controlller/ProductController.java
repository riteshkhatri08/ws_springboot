package com.ritesh.springboot.shopping.controlller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.springboot.shopping.entities.Product;
import com.ritesh.springboot.shopping.service.ProductService;

@RestController()
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // @GetMapping(value="/products")
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {

        // return productService.getProductById(id)
        // .map(ResponseEntity::ok) // Return ok if product is present
        // .orElse(ResponseEntity.notFound().build()); // return not found if product is
        // not found

        // ? Combines map and orelse from above 2 lines
        return ResponseEntity.of(productService.getProductById(id));

    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        // If product is mapped send created status else send internal server error
        return productService.addProduct(product)
                .map(p -> ResponseEntity.created(URI.create("/products/" + p.getId())).body(p))
                .orElse(ResponseEntity.internalServerError().build());
    }
}
