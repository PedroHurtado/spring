package com.example.demo.domain.ingredient.entities;

import java.util.Date;
import java.util.UUID;

import com.example.demo.common.AgregateRoot;
import com.example.demo.domain.ingredient.events.AddIngredientEvent;
import com.example.demo.domain.ingredient.events.UpdateIngredientEvent;

import lombok.Getter;
import lombok.Value;

@Getter
public class Ingredient extends AgregateRoot {

    private final Ingredient.IngredientId id;
    private String name;
    private double price;

    protected Ingredient(IngredientId id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void Update(String name, double price) {
        // UPDATE EVENT
        this.name = name;
        this.price = price;

        var updateIngredientEvent = new UpdateIngredientEvent(
            UUID.randomUUID(),
            new Date(), 
            "update-ingredient", 
            new UpdateIngredientEvent.Data(id.value, name, price)
        );
        add(updateIngredientEvent);
    }

    public static Ingredient Create(IngredientId id, String name, double price){
        //CREATE EVENT 
        var ingredient =  new Ingredient(id, name, price);
        var createIngredientEvent = new AddIngredientEvent(
            UUID.randomUUID(),
            new Date(), 
            "add-ingredient", 
            new AddIngredientEvent.Data(id.value, name, price)
        );
        ingredient.add(createIngredientEvent);
        return ingredient;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof IngredientId i) {
            return i.equals(id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Value
    public static class IngredientId {
        private final UUID value;
    }
}
