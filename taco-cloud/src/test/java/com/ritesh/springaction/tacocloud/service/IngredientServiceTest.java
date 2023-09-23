package com.ritesh.springaction.tacocloud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import com.ritesh.springaction.tacocloud.model.Ingredient;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class IngredientServiceTest {

    @Autowired
    IngredientService service;

    @Autowired
    CacheManager cacheManager;

    private static final String ID_TO_TEST = "FLTO";
    private static final String INGREDIENTS_CACHE_NAME = "ingredientsCache";

    @Test
    void testGetAll() {
        log.debug("Calling get all Ingredients");
        List<Ingredient> results = service.getAll();

        assertFalse(results.isEmpty());
        assertTrue(results.stream().filter(i -> i.getId().equals(ID_TO_TEST)).findAny().isPresent());

    }

    @Test
    void testGetById() {

        log.debug("First call to  getById for " + ID_TO_TEST);
        Optional<Ingredient> result1 = service.getById(ID_TO_TEST);
        assertTrue(result1.isPresent());
        assertEquals(ID_TO_TEST, result1.get().getId());

        log.debug("Second call to getById for " + ID_TO_TEST);
        Optional<Ingredient> result2 = service.getById(ID_TO_TEST);
        assertTrue(result2.isPresent());
        assertEquals(ID_TO_TEST, result2.get().getId());
    }

    @Test
    void testCaching() {
        log.info("Cache Names - ");
        cacheManager.getCacheNames().forEach(log::info);

        Cache ingredientCache = cacheManager.getCache("ingredientsCache");
        assertNotNull(ingredientCache);

        // log.info("Ingredient Cache entries -");
        // ingredientCache.

        ValueWrapper value = ingredientCache.get(ID_TO_TEST);
    
        assertNotNull(value);
        assertInstanceOf(Ingredient.class, value.get());
        assertEquals(ID_TO_TEST, ((Ingredient) value.get()).getId());

    }
}
