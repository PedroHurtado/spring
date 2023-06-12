package com.example.demo.domain.ingredient;

import java.util.UUID;

import lombok.Getter;
import lombok.Value;

@Getter
public class Ingredient {

    private final Ingredient.IngredientId id;
    private  String name;
    private  double price;
    protected Ingredient(IngredientId id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void Update(String name,double price){
        //UPDATE EVENT
        this.name = name;
        this.price = price;
    }
    public static Ingredient Create(IngredientId id, String name, double price){
        //CREATE EVENT 
        return new Ingredient(id, name, price);
    }
    @Override
    public boolean equals(Object o) {
        
       if(o instanceof IngredientId i){
        return i.equals(id);
       }
       return false;
    }
    @Override
    public int hashCode(){        
        return id.hashCode();
    }
    @Value
    public static class IngredientId{
        private final UUID value;
    }
}
