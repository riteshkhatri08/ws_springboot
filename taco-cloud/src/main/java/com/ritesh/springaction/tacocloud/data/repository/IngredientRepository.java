package com.ritesh.springaction.tacocloud.data.repository;

import java.util.Optional;

import com.ritesh.springaction.tacocloud.model.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String Id);

    Ingredient save(Ingredient ingredient);

}
