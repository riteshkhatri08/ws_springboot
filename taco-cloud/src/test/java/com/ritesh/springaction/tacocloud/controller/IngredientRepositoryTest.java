package com.ritesh.springaction.tacocloud.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.ritesh.springaction.tacocloud.Type;
import com.ritesh.springaction.tacocloud.data.repository.IngredientRepository;
import com.ritesh.springaction.tacocloud.model.Ingredient;

// @SpringBootTest
public class IngredientRepositoryTest {

    // @Autowired
    IngredientRepository repo;

    // @Test
    void testFindById() {

        Optional<Ingredient> ingredient = repo.findById("FLTO");

        assertTrue(ingredient.isPresent());
        assertEquals("FLTO", ingredient.get().getId());
        assertEquals(Type.WRAP, ingredient.get().getType());

    }

}
