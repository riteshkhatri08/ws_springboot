package com.ritesh.springaction.tacocloud.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ritesh.springaction.tacocloud.data.repository.IngredientRepository;
import com.ritesh.springaction.tacocloud.model.Ingredient;

@SpringBootTest
public class IngredientRepositoryTest {

    @Autowired
    IngredientRepository repo;

@Test
void testFindById(){

   Optional<Ingredient> ingredient =  repo.findById("FLTO");

   assertTrue(ingredient.isPresent());
   assertEquals("FLTO",ingredient.get().getId());
   assertEquals(Ingredient.Type.WRAP , ingredient.get().getType());

}

}
