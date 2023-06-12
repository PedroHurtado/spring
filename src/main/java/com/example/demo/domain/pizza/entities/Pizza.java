package com.example.demo.domain.pizza.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.example.demo.domain.pizza.exceptions.ExceptionPizza;

import lombok.Getter;
import lombok.Value;

@Getter
public class Pizza {
    private final PizzaId id;
    private String name;
    private String description;
    private String url;
    private Set<IngredientPizza> ingredients = new HashSet<>();

    public Pizza(PizzaId id, String name, String description, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void addIngredient(IngredientPizza ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(IngredientPizza ingredient) {
        if (!this.ingredients.contains(ingredient)) {
            throw new ExceptionPizza(
                "el ingrediente no existe en la pizza", 
                1500);
        }
        this.ingredients.remove(ingredient);
    }

    public double getPrice() {
        return this.ingredients.stream()
                .map(i -> i.getPrice())
                .reduce(0.0D, (acumulator, value) -> acumulator + value) * 1.2D;
        
    }

    public List<IngredientPizza> getIngredients(){
        return ingredients.stream().toList();
    }

    public static Pizza create(PizzaId id, String name, String description, String url) {

        return new Pizza(id, name, description, url);
    }

    public void udpate(String name, String description, String url){
        this.name = name;
        this.description = description;
        this.url = url;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PizzaId p) {
            return p.equals(id);
        }
        return false;
    }

    @Value
    public static class PizzaId {
        private final UUID value;
    }
}
