package com.ritesh.springaction.tacocloud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ritesh.springaction.tacocloud.dao.IngredientJPARepository;
import com.ritesh.springaction.tacocloud.model.Ingredient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IngredientService {

    @Autowired
    IngredientJPARepository repository;

    @Cacheable("ingredientsCache")
    public List<Ingredient> getAll() {
        log.info("Fetching all ingredient");

        List<Ingredient> result = new ArrayList<Ingredient>();
        repository.findAll().forEach(result::add);

        return result;

    }

    @Cacheable("ingredientsCache")
    public Optional<Ingredient> getById(String id) {
        log.info("Fetching ingredient with id " + id);

        Optional<Ingredient> result = repository.findById(id);
        return result;

    }
}
