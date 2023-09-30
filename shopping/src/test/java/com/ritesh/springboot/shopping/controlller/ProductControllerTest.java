package com.ritesh.springboot.shopping.controlller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.ritesh.springboot.shopping.entities.Product;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    JdbcTemplate jdbcTemplate;

    List<Integer> getIds() {
        return jdbcTemplate.queryForList("SELECT id FROM product", Integer.class);
    }

    @Test
    void testGetProductById() {
        getIds().forEach(id -> webTestClient.get().uri("/products/{id}", id)
                .exchange()
                .expectStatus().isOk().expectBody(Product.class)
                .consumeWith(System.out::println));
    }

    @Test
    void testGetProducts() {
        var response = webTestClient.get().uri("/products").exchange();
        System.out.println("response" + response);
        response.expectStatus().isOk()
                .expectBodyList(Product.class)
                .hasSize(3)
                .consumeWith(System.out::println);
    }
}
