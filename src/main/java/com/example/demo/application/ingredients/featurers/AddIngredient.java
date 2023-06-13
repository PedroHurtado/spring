package com.example.demo.application.ingredients.featurers;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Repository;
import com.example.demo.domain.ingredient.entities.Ingredient;
import com.example.demo.domain.ingredient.entities.Ingredient.IngredientId;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;

@Configuration
public class AddIngredient {
   
    @RestController
    @RequestMapping("api/v1/ingredients")
    public class Controller {
        private final Pipeline pipeline;

        public Controller(Pipeline pipeline) {
            this.pipeline = pipeline;
        }
        @PostMapping
        public void add(@RequestBody Request request) {
            System.out.println("request");
            pipeline.send(request);
            System.out.println("response");
        }
    }

    public record Request(String name, double price) implements Command<Voidy> {

    }

    @Component
    public class CommandHandler implements Command.Handler<Request, Voidy> {

        private final Repository.Add<Ingredient> repository;

        public CommandHandler(Repository.Add<Ingredient> repository) {
            this.repository = repository;
        }

        @Override
        public Voidy handle(Request arg0) {
            var ingredient = Ingredient.Create(new IngredientId(UUID.randomUUID()), arg0.name, arg0.price);
            repository.add(ingredient);
            return new Voidy();
        }

    }

}
