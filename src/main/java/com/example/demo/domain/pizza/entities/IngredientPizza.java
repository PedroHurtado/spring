package com.example.demo.domain.pizza.entities;

import java.util.UUID;

import lombok.Getter;
import lombok.Value;

@Getter
public class IngredientPizza {
    
    private final IngredientPizzaId id;
    private  String name;
    private  double price;
    protected IngredientPizza(IngredientPizzaId id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void Update(String name,double price){
        //UPDATE EVENT
        this.name = name;
        this.price = price;
    }
    public static IngredientPizza Create(IngredientPizzaId id, String name, double price){
        //CREATE EVENT 
        return new IngredientPizza(id, name, price);
    }
    @Override
    public boolean equals(Object o) {
        
       if(o instanceof IngredientPizzaId i){
        return i.equals(id);
       }
       return false;
    }
    @Override
    public int hashCode(){        
        return id.hashCode();
    }
    @Value
    public static class IngredientPizzaId{
        private final UUID value;
    }
}
