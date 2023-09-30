package com.ritesh.springboot.shopping.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.Validator;

@SpringBootTest
public class ProductTest {

    @Autowired
    private Validator validator;

    @Test
    public void blankNameIsNotValid() {

        Product product = new Product("   ", BigDecimal.valueOf(25.00));

        // Call all validations defined on fields of this class
        var violiations = validator.validate(product);

        assertEquals(1, violiations.size());
        assertEquals("Name is Required", violiations.iterator().next().getMessage());

    }

    @Test
    public void priceMustBePositiveOrZeroIsNotValid() {
        Product product = new Product("Golf Kit", BigDecimal.valueOf(-1.0));

        var violiations = validator.validate(product);

        assertEquals(1, violiations.size());
        assertEquals("Price must be positive or zero", violiations.iterator().next().getMessage());
    }

    @Test
    public void priceIsNullIsNotValid() {
        Product product = new Product("Golf Kit", null);

        var violiations = validator.validate(product);

        assertEquals(1, violiations.size());
        assertEquals("Price is Required", violiations.iterator().next().getMessage());
    }
}
