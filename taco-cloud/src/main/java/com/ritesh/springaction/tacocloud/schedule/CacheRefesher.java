package com.ritesh.springaction.tacocloud.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ritesh.springaction.tacocloud.model.Ingredient;
import com.ritesh.springaction.tacocloud.service.IngredientService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CacheRefesher {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private IngredientService ingredientService;

    private static final String INGREDIENTS_CACHE_NAME = "ingredientsCache";

    public void fillIngredientsCache() {
        List<Ingredient> ingredients = ingredientService.getAll();
        Cache ingredientsCache = cacheManager.getCache(INGREDIENTS_CACHE_NAME);
        ingredients.forEach(ingredient -> ingredientsCache.putIfAbsent(ingredient.getId(), ingredient));
        // ingredients.forEach(System.out::print);
        System.out.println("\n");

    }

    @Scheduled(initialDelay = 3600000, fixedDelay = 3600000)
    @CacheEvict(value=INGREDIENTS_CACHE_NAME, allEntries = true)
    public void refillIngredientsCache(){
        fillIngredientsCache();
        log.info("Refreshed " + INGREDIENTS_CACHE_NAME);
    }
}
