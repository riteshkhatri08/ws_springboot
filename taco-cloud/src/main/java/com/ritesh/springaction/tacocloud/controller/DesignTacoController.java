package com.ritesh.springaction.tacocloud.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ritesh.springaction.tacocloud.model.Ingredient;
import com.ritesh.springaction.tacocloud.model.Ingredient.Type;
import com.ritesh.springaction.tacocloud.model.Taco;
import com.ritesh.springaction.tacocloud.model.TacoOrder;

import lombok.extern.slf4j.Slf4j;

@Slf4j // ? Automaticall generate slf4j logger
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder") // ? tacoOrder i.e put in Model and will be maintained in session
public class DesignTacoController {

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @ModelAttribute // ? @ModelAttribute methods are invoked before the controller methods annotated with @RequestMapping are invoked.
    //? This is because the model object has to be created before any processing starts inside the controller methods.
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")// ? This Model attribute will stay for the session
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
