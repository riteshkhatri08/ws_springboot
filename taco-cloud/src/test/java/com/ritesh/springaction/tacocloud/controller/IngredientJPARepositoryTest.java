package com.ritesh.springaction.tacocloud.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ritesh.springaction.tacocloud.dao.IngredientJPARepository;
import com.ritesh.springaction.tacocloud.model.Ingredient;

@SpringBootTest
public class IngredientJPARepositoryTest {

    @Autowired
    IngredientJPARepository repo;

    @Test
    void testFindById() {

        Iterable<Ingredient> ingredients = repo.findAll();
        System.out.println("LIST OF INGRDIENTS IN DB");
        ingredients.forEach(System.out::println);

        // Optional<Ingredient> ingredient = repo.findById("FLTO");

        // assertTrue(ingredient.isPresent());
        // assertEquals("FLTO", ingredient.get().getId());
        // assertEquals(Ingredient.Type.WRAP, ingredient.get().getType());

    }
}