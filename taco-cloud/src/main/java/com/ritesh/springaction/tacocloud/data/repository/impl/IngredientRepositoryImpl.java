package com.ritesh.springaction.tacocloud.data.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ritesh.springaction.tacocloud.data.repository.IngredientRepository;
import com.ritesh.springaction.tacocloud.model.Ingredient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    // ? All jdbc queries are executed through this jdbc template
    JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {

        return jdbcTemplate.query(
                "select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {

       log.debug("[FETCHING INGREDIENT WITH ID  - =  " + id + " o]");
        List<Ingredient> results = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,
                id);
        return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {

        int noOfRowsUpdated = jdbcTemplate.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());

        return (noOfRowsUpdated > 0) ? ingredient : null;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum)
            throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }
}
