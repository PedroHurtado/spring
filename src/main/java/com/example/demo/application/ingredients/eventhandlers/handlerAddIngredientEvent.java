package com.example.demo.application.ingredients.eventhandlers;

import org.springframework.stereotype.Component;

import com.example.demo.domain.ingredient.events.AddIngredientEvent;

import an.awesome.pipelinr.Notification;

@Component
public class handlerAddIngredientEvent implements Notification.Handler<AddIngredientEvent> {

    @Override
    public void handle(AddIngredientEvent arg0) {
        System.out.println("process events");
        
    }

    
}
