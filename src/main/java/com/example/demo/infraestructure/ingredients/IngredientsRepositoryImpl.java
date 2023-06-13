package com.example.demo.infraestructure.ingredients;

import org.springframework.stereotype.Component;

import com.example.demo.domain.ingredient.IngredientRepository;
import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.ingredient.entities.Ingredient.IngredientId;

@Component
public class IngredientsRepositoryImpl  implements IngredientRepository{

    @Override
    public void add(Ingredient entity) {
       
    }

    @Override
    public void update(Ingredient entity) {
       
    }

    @Override
    public Ingredient get(IngredientId id) {
        return null;
    }

    @Override
    public void remove(Ingredient entity) {
       
    }
    
}
