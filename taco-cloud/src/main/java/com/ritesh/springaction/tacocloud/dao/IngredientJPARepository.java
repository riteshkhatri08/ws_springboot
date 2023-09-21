package com.ritesh.springaction.tacocloud.dao;

import org.springframework.data.repository.CrudRepository;

import com.ritesh.springaction.tacocloud.model.Ingredient;


// ? CRUDRepostiory provides methods for general purpose persistence of entities
// ?  For more featrues we need to create a Custom Repostiory 
public interface IngredientJPARepository extends CrudRepository<Ingredient, String> {
}
