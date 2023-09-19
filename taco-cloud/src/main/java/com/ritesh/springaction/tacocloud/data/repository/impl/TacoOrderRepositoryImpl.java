package com.ritesh.springaction.tacocloud.data.repository.impl;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.ritesh.springaction.tacocloud.model.Ingredient;
import com.ritesh.springaction.tacocloud.model.Taco;
import com.ritesh.springaction.tacocloud.model.TacoOrder;

@Repository
public class TacoOrderRepositoryImpl implements TacoOrderRepository {

        private JdbcOperations jdbcOperations;

        public TacoOrderRepositoryImpl(JdbcOperations jdbcOperations) {
                this.jdbcOperations = jdbcOperations;
        }

        @Override
        public TacoOrder save(TacoOrder tacoOrder) {

                // To generate a preparedStatement
                // Descirbes the insert statement and the type of params that'll be passed
                PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(
                                "insert into Taco_Order "
                                                + "(delivery_name, delivery_street, delivery_city, "
                                                + "delivery_state, delivery_zip, cc_number, "
                                                + "cc_expiration, cc_cvv, placed_at) "
                                                + "values (?,?,?,?,?,?,?,?,?)",
                                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP);

                // To return id of inserted row
                preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

                // Set order date
                tacoOrder.setPlacedAt(new Date());

                // Preapred Statement Creator object accepts input values for sql defiend in
                // prepared statement creator factory
                PreparedStatementCreator preparedStatementCreator = preparedStatementCreatorFactory
                                .newPreparedStatementCreator(

                                                Arrays.asList(
                                                                tacoOrder.getDeliveryName(),
                                                                tacoOrder.getDeliveryStreet(),
                                                                tacoOrder.getDeliveryCity(),
                                                                tacoOrder.getDeliveryState(),
                                                                tacoOrder.getDeliveryZip(),
                                                                tacoOrder.getCcNumber(),
                                                                tacoOrder.getCcExpiration(),
                                                                tacoOrder.getCcCVV(),
                                                                tacoOrder.getPlacedAt()));

                GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

                // ! now we can call update using JDBCOperations class which accepts prepared
                // ! Statement creator and generated key holder to store returned object
                jdbcOperations.update(preparedStatementCreator, generatedKeyHolder);

                // ? Get the taco id returned by DB through generatedKeyHolder
                Long tacoOrderId = generatedKeyHolder.getKey().longValue();
                tacoOrder.setId(tacoOrderId);

                // ? Now That Taco order has been saved in db we need to save all Tacos from
                // ? that order also in db
                int tacoNumber = 1;
                for (Taco taco : tacoOrder.getTacos()) {
                        saveTaco(tacoOrderId, tacoNumber++, taco);
                }

                return tacoOrder;
        }

        private Long saveTaco(Long tacoOrderId, int tacoOrderKey, Taco taco) {

                taco.setCreatedAt(new Date());

                PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory(

                                "INSERT into TACO"
                                                + "(name , created_at, taco_order, taco_order_key)"
                                                + "values (?, ?, ?, ?)",
                                Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG);
                preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

                PreparedStatementCreator preparedStatementCreator = preparedStatementCreatorFactory
                                .newPreparedStatementCreator(
                                                Arrays.asList(
                                                                taco.getName(),
                                                                taco.getCreatedAt(),
                                                                tacoOrderId,
                                                                tacoOrderKey));

                GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

                jdbcOperations.update(preparedStatementCreator, generatedKeyHolder);

                long tacoId = generatedKeyHolder.getKey().longValue();
                taco.setId(tacoId);

                // ! save ingredients used in a taco
                saveIngredientRefs(tacoId, taco.getIngredients());

                return tacoId;

        }

        private void saveIngredientRefs(long tacoId, List<Ingredient> ingredients) {

                int key = 0;

                for (Ingredient ingredient : ingredients) {

                        jdbcOperations.update(
                                        "insert into Ingredient_Ref (ingredient, taco, taco_key) "
                                                        + "values (?, ?, ?)",
                                        ingredient.getId(), tacoId, key++);
                }
        }

}
