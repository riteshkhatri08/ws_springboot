package com.ritesh.springaction.tacocloud.data.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ritesh.springaction.tacocloud.model.Ingredient;

@Repository
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String Id);

    Ingredient save(Ingredient ingredient);

}
