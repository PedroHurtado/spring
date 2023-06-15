package com.example.demo.application.ingredients.featurers;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Repository.Update;
import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.ingredient.entities.Ingredient.IngredientId;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;

@Configuration
public class UpdateIngredient {   

    public record  Request(String name,Double price){
    }
    public record  RequestId(UUID id, Request request) implements Command<Voidy> {
    }
    @RestController
    @RequestMapping("api/v1/ingredients")
    public class Controller {
        private final Pipeline pipeline;
        public Controller(Pipeline pipeline) {
            this.pipeline = pipeline;
        }
        @PutMapping("/{id}")
        public void update(@PathVariable UUID id,@RequestBody Request request){

            pipeline.send(new RequestId(id, request));
        }
    }

    public class CommandHandler implements Command.Handler<RequestId,Voidy>{

        private final Update<Ingredient,IngredientId> repository;
        public CommandHandler(Update<Ingredient,IngredientId> repository){
            this.repository = repository;
        }

        @Override
        public Voidy handle(RequestId arg0) {
            
            var id = new Ingredient.IngredientId(arg0.id);
            var ingredient=  repository.get(id);
            ingredient.Update(arg0.request.name, arg0.request.price);
            repository.update(ingredient);
            return new Voidy();
        }

    }
}
