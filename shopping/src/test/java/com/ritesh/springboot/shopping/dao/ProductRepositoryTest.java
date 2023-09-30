package com.ritesh.springboot.shopping.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


@DataJpaTest // ! This does autoconfigure it's own db
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // ! This to make sure it uses db init by
                                                                             // ! our spring config
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testFindAllByPriceLessThanEqual() {

        var products = productRepository.findAllByPriceLessThanEqual(BigDecimal.valueOf(100.00));

        products.forEach(System.out::println);

        assertEquals(1, products.size());
    }
}
