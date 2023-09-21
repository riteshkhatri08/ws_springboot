package com.ritesh.springaction.tacocloud.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ritesh.springaction.tacocloud.dao.IngredientJPARepository;
import com.ritesh.springaction.tacocloud.model.Ingredient;

@Component
public class IngredientByIdConvertor implements Converter<String, Ingredient> {

        // @Autowired
        // ApplicationContext context;

        // private IngredientRepository ingredientRepository;

        // public IngredientByIdConvertor(IngredientRepository ingredientRepository) {
        // this.ingredientRepository = ingredientRepository;
        // }

        // CHANGING TO JPA REPOSITORY
        private IngredientJPARepository ingredientRepository;

        public IngredientByIdConvertor(IngredientJPARepository ingredientRepository) {
                this.ingredientRepository = ingredientRepository;
        }

        // private Map<String, Ingredient> ingredientMap = new HashMap<String,
        // Ingredient>();

        // public IngredientByIdConvertor() {

        // Get Ingredients from Db instead of using a hardcoded map

        // ingredientMap.put("FLTO",
        // new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
        // ingredientMap.put("COTO",
        // new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
        // ingredientMap.put("GRBF",
        // new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
        // ingredientMap.put("CARN",
        // new Ingredient("CARN", "Carnitas", Type.PROTEIN));
        // ingredientMap.put("TMTO",
        // new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
        // ingredientMap.put("LETC",
        // new Ingredient("LETC", "Lettuce", Type.VEGGIES));
        // ingredientMap.put("CHED",
        // new Ingredient("CHED", "Cheddar", Type.CHEESE));
        // ingredientMap.put("JACK",
        // new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
        // ingredientMap.put("SLSA",
        // new Ingredient("SLSA", "Salsa", Type.SAUCE));
        // ingredientMap.put("SRCR",
        // new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        // }

        @Override
        public Ingredient convert(String source) {

                // IngredientRepository obj = (IngredientRepository)
                // context.getBean(IngredientRepository.class);
                // log.debug("CHECKED APP CONTEXT FOR IngredientRepositoryImpl = " + obj);

                // // ? Fetch ingredient from db instead of fetching from hardedcoded map
                // log.debug("***********************************************************");
                // log.debug("CALLING findby Id - source = " + source);

                // log.debug("ingredientRepostory = " + obj);
                // Ingredient ing = obj.findById(source).orElse(null);
                // log.debug("Found this ing for above id " + ing);

                return ingredientRepository.findById(source).orElse(null);
                // ingredients.forEach(i -> ingredientMap.put(i.getId(), i));
                //
                // return ingredientMap.get(source);
        }

}
