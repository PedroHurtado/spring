package com.example.demo.infraestructure.ingredients;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.common.AgregateRoot;
import com.example.demo.domain.ingredient.IngredientRepository;
import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.ingredient.entities.Ingredient.IngredientId;

import an.awesome.pipelinr.Pipeline;

@Component
public class IngredientsRepositoryImpl  implements IngredientRepository{


    private final Set<Ingredient> data = new HashSet<>();
    private final Pipeline pipeline;
    public IngredientsRepositoryImpl(Pipeline pipeline ){
        this.pipeline = pipeline;
    }
    @Override
    public void add(Ingredient entity) {
       save(entity);
       data.add(entity);
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
    private void save(Ingredient ingredient){
        System.out.println("before publish events");
        if(ingredient instanceof AgregateRoot ag){
            ag.getEvents().forEach(n->pipeline.send(n));
            ag.clear();
        }
        System.out.println("after publish events");
    }
    
}
